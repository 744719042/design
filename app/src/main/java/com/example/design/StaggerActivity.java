package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.design.recycler.GridItemDecoration;
import com.example.design.recycler.GroupRecyclerAdapter;

import java.util.Collections;

public class StaggerActivity extends AppCompatActivity {
    private ItemTouchHelper touchHelper;
    private GroupRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.addItemDecoration(new GridItemDecoration());
        recyclerView.setAdapter(adapter = new GroupRecyclerAdapter(this));

        touchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int flag = 0;
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager ||
                        recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                    int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    int swipeFlag = 0;
                    flag = makeMovementFlags(dragFlag, swipeFlag);
                } else {
                    int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
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

            }
        });
        touchHelper.attachToRecyclerView(recyclerView);
    }
}
