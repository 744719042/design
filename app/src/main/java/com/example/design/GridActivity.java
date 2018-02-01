package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.design.recycler.GridItemDecoration;
import com.example.design.recycler.GridRecyclerAdapter;

public class GridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (GridRecyclerAdapter.users.get(position).isHuman()) {
                    return 1;
                } else {
                    return 3;
                }
            }
        });
        recyclerView.addItemDecoration(new GridItemDecoration());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new GridRecyclerAdapter(this));
    }
}
