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
 * Created by Administrator on 2018/2/1.
 */

public class LineDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "LineDecoration";
    private Paint paint;

    public LineDecoration() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Log.d(TAG, "onDraw()");
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = parent.getChildAt(i);
            int bottom = view.getBottom();
            c.drawRect(parent.getPaddingLeft(), bottom - CommonUtils.dp2px(25),
                    parent.getWidth() - parent.getPaddingRight(), bottom + CommonUtils.dp2px(5), paint);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        Log.d(TAG, "onDrawOver()");
//        int count = parent.getChildCount();
//        for (int i = 0; i < count; i++) {
//            View view = parent.getChildAt(i);
//            int bottom = view.getBottom();
//            c.drawRect(parent.getPaddingLeft(), bottom - CommonUtils.dp2px(25),
//                    parent.getWidth() - parent.getPaddingRight(), bottom + CommonUtils.dp2px(5), paint);
//        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Log.d(TAG, "getItemOffsets()");
        outRect.bottom = CommonUtils.dp2px(5);
    }
}
