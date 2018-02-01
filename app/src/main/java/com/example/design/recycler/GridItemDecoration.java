package com.example.design.recycler;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.design.utils.CommonUtils;

/**
 * Created by Administrator on 2018/2/1.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.right = CommonUtils.dp2px(1);
        outRect.bottom = CommonUtils.dp2px(3);
    }
}
