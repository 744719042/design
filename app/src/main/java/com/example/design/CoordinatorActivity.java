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

import com.example.design.recycler.LineDecoration;
import com.example.design.recycler.RecyclerAdapter;

public class CoordinatorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new LineDecoration());
        recyclerView.setAdapter(new RecyclerAdapter(this));
    }

    public static final class MessageBehavior extends CoordinatorLayout.Behavior<ImageView> {
        public MessageBehavior() {
        }

        public MessageBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
            return dependency instanceof Toolbar;
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
            child.setY(dependency.getY());
            child.setScaleX(dependency.getScaleX());
            child.setScaleY(dependency.getScaleY());
            return super.onDependentViewChanged(parent, child, dependency);
        }
    }
}
