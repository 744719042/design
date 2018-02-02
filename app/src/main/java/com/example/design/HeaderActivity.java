package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.design.recycler.LineDecoration;
import com.example.design.recycler.RecyclerAdapter;
import com.example.design.widget.HeaderRecyclerView;

public class HeaderActivity extends AppCompatActivity {
    private HeaderRecyclerView recyclerView;
    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        inflater = LayoutInflater.from(this);
        recyclerView = (HeaderRecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new LineDecoration());
        recyclerView.setAdapter(new RecyclerAdapter(this));
        View header1 = inflater.inflate(R.layout.header_view_1, recyclerView, false);
        recyclerView.addHeaderView(R.id.header_view_1, header1);
        View header2 = inflater.inflate(R.layout.header_view_2, recyclerView, false);
        recyclerView.addHeaderView(R.id.header_view_2, header2);
        View footer1 = inflater.inflate(R.layout.footer_view_1, recyclerView, false);
        recyclerView.addFooterView(R.id.footer_view_1, footer1);
        View footer2 = inflater.inflate(R.layout.footer_view_2, recyclerView, false);
        recyclerView.addFooterView(R.id.footer_view_2, footer2);
    }


}
