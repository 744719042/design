package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.design.recycler.GridItemDecoration;
import com.example.design.recycler.GroupRecyclerAdapter;
import com.example.design.widget.HeaderRecyclerView;

public class HeaderGridActivity extends AppCompatActivity {
    private HeaderRecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_grid);
        recyclerView = (HeaderRecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (GroupRecyclerAdapter.users.get(position - recyclerView.getHeaderCount()).isHuman()) {
                    return 1;
                } else {
                    return 3;
                }
            }
        });
        recyclerView.addItemDecoration(new GridItemDecoration());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new GroupRecyclerAdapter(this));
        LayoutInflater inflater = LayoutInflater.from(this);
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
