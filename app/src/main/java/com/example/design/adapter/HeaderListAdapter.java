package com.example.design.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/2/1.
 */

public class HeaderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SparseArray<View> mHeaderViews;
    private SparseArray<View> mFooterViews;
    private SparseIntArray mHeaderViewType;
    private SparseIntArray mFooterViewType;
    private RecyclerView.Adapter mWrapperAdapter;

    public HeaderListAdapter(RecyclerView.Adapter adapter, SparseArray<View> headerViews,
                             SparseIntArray headerViewType, SparseArray<View> footerViews,
                             SparseIntArray footerViewType) {
        this.mWrapperAdapter = adapter;
        this.mHeaderViews = headerViews;
        this.mHeaderViewType = headerViewType;
        this.mFooterViews = footerViews;
        this.mFooterViewType = footerViewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View headerView = mHeaderViews.get(viewType);
        View footerView = mFooterViews.get(viewType);
        if (headerView != null) {
            viewHolder = new HeaderViewHolder(headerView);
        } else if (footerView != null) {
            viewHolder = new HeaderViewHolder(footerView);
        } else {
            viewHolder = mWrapperAdapter.onCreateViewHolder(parent, viewType);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position >= mHeaderViews.size() && position < mHeaderViews.size() + mWrapperAdapter.getItemCount()) {
            mWrapperAdapter.onBindViewHolder(holder, position - mHeaderViews.size());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mHeaderViews.size()) {
            return mHeaderViewType.get(position);
        } else if (position < mHeaderViews.size() + mWrapperAdapter.getItemCount()) {
            return mWrapperAdapter.getItemViewType(position - mHeaderViews.size());
        } else {
            return mFooterViewType.get(position - mHeaderViews.size() - mWrapperAdapter.getItemCount());
        }
    }

    private static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return mWrapperAdapter.getItemCount() + mHeaderViews.size() + mFooterViews.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(),
                    ((GridLayoutManager) layoutManager).getSpanCount());
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = ((GridLayoutManager) layoutManager).getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position < mHeaderViews.size()) {
                        return gridLayoutManager.getSpanCount();
                    } else if (position < mHeaderViews.size() + mWrapperAdapter.getItemCount()) {
                        return spanSizeLookup.getSpanSize(position);
                    } else {
                        return gridLayoutManager.getSpanCount();
                    }
                }
            });

            recyclerView.setLayoutManager(gridLayoutManager);
        }
    }
}
