package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.design.recycler.RecyclerAdapter;
import com.example.design.recycler.StickHeaderDecoration;

public class StickHeaderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick_header);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new StickHeaderDecoration(new StickHeaderDecoration.SectionCallback() {
            @Override
            public boolean isFirstItem(int position) {
                return position == 0 || position == 4 || position == 7;
            }

            @Override
            public int getGroupId(int position) {
                if (position < 4) {
                    return 0;
                } else if (position < 7) {
                    return 1;
                } else {
                    return 2;
                }
            }

            @Override
            public String getTitle(int position) {
                return RecyclerAdapter.groups.get(getGroupId(position));
            }
        }));
        recyclerView.setAdapter(new RecyclerAdapter(this));
    }
}
