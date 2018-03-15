package com.example.design.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.view.CollapsibleActionView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.design.R;
import com.example.design.utils.CommonUtils;

/**
 * Created by Administrator on 2018/3/15.
 */

public class SearchBar extends LinearLayout implements CollapsibleActionView {
    private LinearLayout searchLayout;
    private EditText editText;
    private Button submit;
    private ImageView actionView;

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        View view = LayoutInflater.from(getContext()).
                inflate(R.layout.layout_search_bar, this, false);
        addView(view);

        ImageView imageView = new ImageView(getContext());
        LayoutParams params = new LayoutParams(CommonUtils.dp2px(30),
                CommonUtils.dp2px(30), Gravity.CENTER_VERTICAL);
        imageView.setImageResource(R.drawable.sun_set);
        addView(imageView, params);
        this.actionView = imageView;
        this.searchLayout = (LinearLayout) view;
        this.editText = (EditText) view.findViewById(R.id.edit_query);
        this.submit = (Button) view.findViewById(R.id.submit);
        this.submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActionViewExpanded() {
        this.actionView.setVisibility(View.GONE);
        this.searchLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActionViewCollapsed() {
        this.searchLayout.setVisibility(View.GONE);
        this.actionView.setVisibility(View.VISIBLE);
    }
}
