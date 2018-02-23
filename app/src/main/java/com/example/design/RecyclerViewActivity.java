package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.design.recycler.LineDecoration;
import com.example.design.recycler.RecyclerAdapter;

import java.util.Collections;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemTouchHelper touchHelper;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new LineDecoration());
        recyclerView.setAdapter(adapter = new RecyclerAdapter(this));

        touchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int flag = 0;
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    int swipeFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    flag = makeMovementFlags(dragFlag, swipeFlag);
                } else {
                    int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    int swipeFlag = 0;
                    flag = makeMovementFlags(dragFlag, swipeFlag);
                }
                return flag;
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int pos = viewHolder.getAdapterPosition();
                int tgtPos = target.getAdapterPosition();
                if (pos > tgtPos) {
                    for (int i = pos - 1; i >= tgtPos; i--) {
                        Collections.swap(adapter.getData(), i, i + 1);
                    }
                } else {
                    for (int i = pos + 1; i <= tgtPos; i++) {
                        Collections.swap(adapter.getData(), i, i - 1);
                    }
                }

                adapter.notifyItemMoved(pos, tgtPos);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                adapter.getData().remove(pos);
                adapter.notifyItemRemoved(pos);
            }
        });
        touchHelper.attachToRecyclerView(recyclerView);
    }
}
