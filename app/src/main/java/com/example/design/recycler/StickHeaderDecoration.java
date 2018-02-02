package com.example.design.recycler;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.design.utils.CommonUtils;

/**
 * Created by Administrator on 2018/2/2.
 */

public class StickHeaderDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "StickHeaderDecoration";
    private Paint paint;
    private SectionCallback callback;
    private int titleHeight;

    public StickHeaderDecoration(SectionCallback callback) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setTextSize(CommonUtils.dp2px(30));
        this.callback = callback;
        this.titleHeight = CommonUtils.dp2px(45);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        for (int i = 0, count = parent.getChildCount(); i < count; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            if (callback.isFirstItem(position)) {
                paint.setColor(Color.BLUE);
                c.drawRect(parent.getPaddingLeft(), view.getTop() - titleHeight,
                            parent.getWidth() - parent.getPaddingRight(), view.getTop(), paint);
                paint.setColor(Color.WHITE);
                c.drawText(callback.getTitle(position), parent.getPaddingLeft() + CommonUtils.dp2px(10),
                        view.getTop() - CommonUtils.dp2px(10), paint);
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        View view = parent.getChildAt(0);
        View view2 = parent.getChildAt(1);
        int position = parent.getChildAdapterPosition(view);
        int curGroup = callback.getGroupId(position);
        int position2 = parent.getChildAdapterPosition(view2);
        int nextGroup = callback.getGroupId(position2);

        int textY = titleHeight;
        if (curGroup != nextGroup) {
            if (titleHeight > view.getBottom()) {
                textY = view.getBottom();
            }
        }

        paint.setColor(Color.BLUE);
        c.drawRect(parent.getPaddingLeft(), 0,
                parent.getWidth() - parent.getPaddingRight(), textY, paint);
        paint.setColor(Color.WHITE);
        c.drawText(callback.getTitle(position), parent.getPaddingLeft() + CommonUtils.dp2px(10),
                textY - CommonUtils.dp2px(10), paint);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Log.d(TAG, "getItemOffsets()");
        int position = parent.getChildAdapterPosition(view);
        if (callback.isFirstItem(position)) {
            outRect.top = CommonUtils.dp2px(45);
        } else {
            outRect.top = 0;
        }
    }

    public interface SectionCallback {
        boolean isFirstItem(int position);
        int getGroupId(int position);
        String getTitle(int position);
    }
}
