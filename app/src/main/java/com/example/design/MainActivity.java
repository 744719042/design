package com.example.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button tvBtn;
    private Button recyclerBtn;
    private Button gridButton;
    private Button staggerButton;
    private Button headerButton;
    private Button headerGridButton;
    private Button stickHeaderButton;
    private Button updateButton;
    private Button constraintBtn;
    private Button coordinatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBtn = (Button) findViewById(R.id.textview);
        recyclerBtn = (Button) findViewById(R.id.recyclerView);
        gridButton = (Button) findViewById(R.id.gridLayout);
        staggerButton = (Button) findViewById(R.id.staggerView);
        headerButton = (Button) findViewById(R.id.headerRecyclerView);
        headerGridButton = (Button) findViewById(R.id.headerGridView);
        stickHeaderButton = (Button) findViewById(R.id.stickheader);
        updateButton = (Button) findViewById(R.id.updateButton);
        constraintBtn = (Button) findViewById(R.id.constraint);
        coordinatorBtn = (Button) findViewById(R.id.coordinator);
        tvBtn.setOnClickListener(this);
        recyclerBtn.setOnClickListener(this);
        gridButton.setOnClickListener(this);
        staggerButton.setOnClickListener(this);
        headerButton.setOnClickListener(this);
        headerGridButton.setOnClickListener(this);
        stickHeaderButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        constraintBtn.setOnClickListener(this);
        coordinatorBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvBtn) {
            Intent intent = new Intent(this, TextViewActivity.class);
            startActivity(intent);
        } else if (v == recyclerBtn) {
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        } else if (v == gridButton) {
            Intent intent = new Intent(this, GridActivity.class);
            startActivity(intent);
        } else if (v == staggerButton) {
            Intent intent = new Intent(this, StaggerActivity.class);
            startActivity(intent);
        } else if (v == headerButton) {
            Intent intent = new Intent(this, HeaderActivity.class);
            startActivity(intent);
        } else if (v == headerGridButton) {
            Intent intent = new Intent(this, HeaderGridActivity.class);
            startActivity(intent);
        } else if (v == stickHeaderButton) {
            Intent intent = new Intent(this, StickHeaderActivity.class);
            startActivity(intent);
        } else if (v == updateButton) {
            Intent intent = new Intent(this, UpdateActivity.class);
            startActivity(intent);
        } else if (v == constraintBtn) {
            Intent intent = new Intent(this, ConstraintActivity.class);
            startActivity(intent);
        } else if (v == coordinatorBtn) {
            Intent intent = new Intent(this, CoordinatorActivity.class);
            startActivity(intent);
        }
    }
}
