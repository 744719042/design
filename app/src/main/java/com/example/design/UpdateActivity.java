package com.example.design;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.design.model.User;
import com.example.design.recycler.DiffRecyclerAdapter;
import com.example.design.recycler.LineDecoration;
import com.example.design.recycler.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private DiffRecyclerAdapter adapter;
//    private Button add;
//    private Button delete;
//    private Button exchange;
//    private Button update;
//    private Button batchAdd;
//    private Button batchDelete;
    private Button batchUpdate;
    private Button batchUpdate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new LineDecoration());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter = new DiffRecyclerAdapter(this, DiffRecyclerAdapter.users));

//        add = (Button) findViewById(R.id.add);
//        add.setOnClickListener(this);
//        delete = (Button) findViewById(R.id.delete);
//        delete.setOnClickListener(this);
//        update = (Button) findViewById(R.id.update);
//        update.setOnClickListener(this);
//        exchange = (Button) findViewById(R.id.exchange);
//        exchange.setOnClickListener(this);
//        batchAdd = (Button) findViewById(R.id.batchAdd);
//        batchAdd.setOnClickListener(this);
//        batchDelete = (Button) findViewById(R.id.batchDelete);
//        batchDelete.setOnClickListener(this);
        batchUpdate = (Button) findViewById(R.id.batchUpdate);
        batchUpdate.setOnClickListener(this);
        batchUpdate2 = (Button) findViewById(R.id.batchUpdate2);
        batchUpdate2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        if (v == add) {
//            User user = new User(R.drawable.tower, "XXXXX", "xxxxxxxxxxxxxxxxxxxxxx");
//            RecyclerAdapter.users.add(1, user);
//            adapter.notifyItemInserted(1);
//            recyclerView.smoothScrollToPosition(1);
//        } else if (v == delete) {
//            if (RecyclerAdapter.users.size() > 1) {
//                RecyclerAdapter.users.remove(1);
//                adapter.notifyItemRemoved(1);
//                recyclerView.smoothScrollToPosition(1);
//            }
//        } else if (v == update) {
//            int count = adapter.getItemCount();
//            int item = new Random().nextInt(count);
//            User user = RecyclerAdapter.users.get(item);
//            user.setName("YYYYY");
//            user.setDesc("yyyyyyyyyyyyyyyyyyyyyyyy");
//            adapter.notifyItemChanged(item);
//            recyclerView.smoothScrollToPosition(item);
//        } else if (v == exchange) {
//            int count = adapter.getItemCount();
//            int item = new Random().nextInt(count);
//            int item2 = (item + 1) % count;
//            User user = RecyclerAdapter.users.get(item);
//            RecyclerAdapter.users.set(item, RecyclerAdapter.users.get(item2));
//            RecyclerAdapter.users.set(item2, user);
//            adapter.notifyItemMoved(item, item2);
//            recyclerView.smoothScrollToPosition(item);
//        } else if (v == batchAdd) {
//            User user1 = new User(R.drawable.tower, "AAAAA", "aaaaaaaaaaaaaaaaaa");
//            User user2 = new User(R.drawable.sun_set, "BBBBBB", "bbbbbbbbbbbbbbbbb");
//            User user3 = new User(R.drawable.waterfall, "CCCCCC", "cccccccccccccccc");
//            List<User> newList = new ArrayList<>();
//            newList.add(user1);
//            newList.add(user2);
//            newList.add(user3);
//            RecyclerAdapter.users.addAll(1, newList);
//            adapter.notifyItemRangeInserted(1, newList.size());
//            recyclerView.smoothScrollToPosition(1);
//        } else if (v == batchDelete) {
//            int item = 3, count = 3, realCount = 0;
//            for (int i = 0; i < count; i++) {
//                if (RecyclerAdapter.users.size() > item) {
//                    RecyclerAdapter.users.remove(item);
//                    realCount++;
//                }
//            }
//            adapter.notifyItemRangeRemoved(item, realCount);
//            recyclerView.smoothScrollToPosition(item);
//        } else

        if (v == batchUpdate) {
            adapter.replace();
        } else if (v == batchUpdate2) {
            adapter.replaceAll();
        }
    }
}
