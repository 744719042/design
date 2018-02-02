package com.example.design.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.design.R;
import com.example.design.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/1.
 */

public class GroupRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static List<User> users = new ArrayList<User>() {
        {
            add(new User("蜀国"));
            add(new User(R.drawable.beach, "刘备", "唯贤唯德，能服于人"));
            add(new User(R.drawable.bamboo, "诸葛亮", "淡泊以明志，宁静以致远"));
            add(new User(R.drawable.road, "关羽", "安能与老兵同列"));
            add(new User(R.drawable.flower, "赵云", "子龙一身是胆"));
            add(new User("魏国"));
            add(new User(R.drawable.lake, "曹操", "宁教我负天下人，不教天下人负我"));
            add(new User(R.drawable.rain, "司马懿", "老而不死是为贼"));
            add(new User(R.drawable.sea, "司马昭", "司马昭之心路人皆知"));
            add(new User("吴国"));
            add(new User(R.drawable.moon, "孙权", "生子当如孙仲谋"));
            add(new User(R.drawable.peach, "周瑜", "既生瑜何生亮"));
            add(new User(R.drawable.pool, "吕蒙", "士别三日当刮目相待"));
        }
    };

    private Context context;
    private LayoutInflater inflater;

    public GroupRecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == R.layout.grid_user_item) {
            View itemView = inflater.inflate(R.layout.grid_user_item, parent, false);
            viewHolder = new RecyclerViewHolder(itemView);
        } else {
            View itemView = inflater.inflate(R.layout.state_item, parent, false);
            viewHolder = new StateViewHolder(itemView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == R.layout.grid_user_item) {
            ((RecyclerViewHolder) holder).bindView(users.get(position));
        } else {
            ((StateViewHolder) holder).bindView(users.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        User user = users.get(position);
        if (user.isHuman()) {
            return R.layout.grid_user_item;
        } else {
            return R.layout.state_item;
        }
    }
}
