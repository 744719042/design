package com.example.design;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.design.recycler.LineDecoration;
import com.example.design.recycler.RecyclerAdapter;
import com.example.design.utils.CommonUtils;

public class CoordinatorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new LineDecoration());
        recyclerView.setAdapter(new RecyclerAdapter(this));
        textView = (TextView) findViewById(R.id.textview);
    }

    public static final class MessageBehavior extends CoordinatorLayout.Behavior<TextView> {
        private int start = 0;
        public MessageBehavior() {
        }

        public MessageBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
            return dependency instanceof Toolbar;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
            if (start == 0) {
                start = (int) dependency.getY();
            }
            float ratio = dependency.getY() / start;
            child.setY(-child.getMeasuredHeight() * ratio);
            return true;
        }
    }

    public static final class DrawableBehavior extends CoordinatorLayout.Behavior<ImageView> {
        private int start = 0;
        private int startX = 0;
        private int startY = 0;
        private int endX = CommonUtils.dp2px(10);
        private int endY = CommonUtils.dp2px(10);
        private int endSize = CommonUtils.dp2px(30);
        private int startSize = 0;
        public DrawableBehavior() {
        }

        public DrawableBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
            return dependency instanceof Toolbar;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
            if (start == 0) {
                start = (int) dependency.getY();
                startX = (int) child.getX();
                startY = (int) child.getY();
                startSize = CommonUtils.dp2px(80);
            }
            float ratio = dependency.getY() / start;
            child.setX(startX + (1 - ratio) * (endX - startX));
            child.setY(startY + (1 - ratio) * (endY - startY));
            child.getLayoutParams().width = (int) (startSize + (1 - ratio) * (endSize - startSize));
            child.getLayoutParams().height = (int) (startSize + (1 - ratio) * (endSize - startSize));
            child.requestLayout();
            return true;
        }
    }
}
