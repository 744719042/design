package com.example.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button tvBtn;
    private Button recyclerBtn;
    private Button gridButton;
    private Button staggerButton;
    private Button contraintBtn;
    private Button coordinatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBtn = (Button) findViewById(R.id.textview);
        recyclerBtn = (Button) findViewById(R.id.recyclerView);
        gridButton = (Button) findViewById(R.id.gridLayout);
        staggerButton = (Button) findViewById(R.id.staggerView);
        contraintBtn = (Button) findViewById(R.id.constraint);
        coordinatorBtn = (Button) findViewById(R.id.coordinator);
        tvBtn.setOnClickListener(this);
        recyclerBtn.setOnClickListener(this);
        gridButton.setOnClickListener(this);
        staggerButton.setOnClickListener(this);
        contraintBtn.setOnClickListener(this);
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
        } else if (v == contraintBtn) {

        } else if (v == coordinatorBtn) {

        }
    }
}
