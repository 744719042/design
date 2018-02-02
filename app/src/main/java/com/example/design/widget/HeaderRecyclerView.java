package com.example.design.widget;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;

import com.example.design.adapter.HeaderListAdapter;


/**
 * Created by Administrator on 2018/2/1.
 */

public class HeaderRecyclerView extends RecyclerView {
    private SparseArray<View> mHeaderViews = new SparseArray<>();
    private SparseArray<View> mFooterViews = new SparseArray<>();
    private SparseIntArray mHeaderViewType = new SparseIntArray();
    private SparseIntArray mFooterViewType = new SparseIntArray();

    public HeaderRecyclerView(Context context) {
        super(context);
    }

    public HeaderRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViews.size() == 0 && mFooterViews.size() == 0) {
            super.setAdapter(adapter);
        } else {
            HeaderListAdapter headerListAdapter = new HeaderListAdapter(adapter, mHeaderViews,
                    mHeaderViewType, mFooterViews, mFooterViewType);
            super.setAdapter(headerListAdapter);
        }
    }

    public void addHeaderView(@IdRes int viewType, View view) {
        mHeaderViews.put(viewType, view);
        mHeaderViewType.put(mHeaderViews.size() - 1, viewType);
        if (!(getAdapter() instanceof HeaderListAdapter)) {
            HeaderListAdapter headerListAdapter = new HeaderListAdapter(getAdapter(), mHeaderViews,
                    mHeaderViewType, mFooterViews, mFooterViewType);
            swapAdapter(headerListAdapter, true);
        }
    }

    public int getHeaderCount() {
        return mHeaderViews.size();
    }

    public void addFooterView(@IdRes int viewType, View view) {
        mFooterViews.put(viewType, view);
        mFooterViewType.put(mFooterViews.size() - 1, viewType);
        if (!(getAdapter() instanceof HeaderListAdapter)) {
            HeaderListAdapter headerListAdapter = new HeaderListAdapter(getAdapter(), mHeaderViews,
                    mHeaderViewType, mFooterViews, mFooterViewType);
            swapAdapter(headerListAdapter, true);
        }
    }

    public int getFooterCount() {
        return mFooterViews.size();
    }
}
