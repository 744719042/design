package com.example.design.recycler;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
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

public class DiffRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    public static List<User> users = new ArrayList<User>() {
        {
            add(new User(R.drawable.beach, "刘备", "唯贤唯德，能服于人"));
            add(new User(R.drawable.bamboo, "诸葛亮", "淡泊以明志，宁静以致远"));
            add(new User(R.drawable.road, "关羽", "安能与老兵同列"));
            add(new User(R.drawable.flower, "赵云", "子龙一身是胆"));
            add(new User(R.drawable.lake, "曹操", "宁教我负天下人，不教天下人负我"));
            add(new User(R.drawable.rain, "司马懿", "老而不死是为贼"));
            add(new User(R.drawable.sea, "司马昭", "司马昭之心路人皆知"));
            add(new User(R.drawable.moon, "孙权", "生子当如孙仲谋"));
            add(new User(R.drawable.peach, "周瑜", "既生瑜何生亮"));
            add(new User(R.drawable.pool, "吕蒙", "士别三日当刮目相待"));
        }
    };

    public static List<User> userList = new ArrayList<User>() {
        {
            add(new User(R.drawable.beach, "刘备", "勿以恶小而为之，勿以善小而不为"));
            add(new User(R.drawable.road, "关羽", "安能与老兵同列"));
            add(new User(R.drawable.bamboo, "诸葛亮", "淡泊以明志，宁静以致远"));
            add(new User(R.drawable.flower, "张飞", "子龙一身是胆"));
            add(new User(R.drawable.lake, "曹操", "宁教我负天下人，不教天下人负我"));
            add(new User(R.drawable.rain, "司马懿", "老而不死是为贼"));
            add(new User(R.drawable.sea, "司马昭", "司马昭之心路人皆知"));
            add(new User(R.drawable.moon, "孙权", "生子当如孙仲谋"));
            add(new User(R.drawable.peach, "周瑜", "既生瑜何生亮"));
            add(new User(R.drawable.pool, "吕蒙", "士别三日当刮目相待"));
        }
    };

    public static SparseArray<String> groups = new SparseArray<>();

    static {
        groups.put(0, "蜀国");
        groups.put(1, "魏国");
        groups.put(2, "吴国");
    }

    private Context context;
    private LayoutInflater inflater;
    private List<User> data;

    public DiffRecyclerAdapter(Context context, List<User> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.user_item, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void replace() {
        this.data = userList;
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return users.size();
            }

            @Override
            public int getNewListSize() {
                return userList.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                User user = users.get(oldItemPosition);
                User newUser = userList.get(newItemPosition);
                return user.getName().equalsIgnoreCase(newUser.getName());
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                User user = users.get(oldItemPosition);
                User newUser = userList.get(newItemPosition);
                return user.equals(newUser);
            }
        }, true);

        diffResult.dispatchUpdatesTo(this);
    }

    public void replaceAll() {
        this.data = userList;
        notifyDataSetChanged();
    }
}
