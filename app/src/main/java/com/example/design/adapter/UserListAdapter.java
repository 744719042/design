package com.example.design.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.design.R;
import com.example.design.model.User;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/2/22.
 */

public class UserListAdapter extends BaseAdapter {
    private static final String TAG = "UserListAdapter";
    private Context context;
    private LayoutInflater inflater;
    private List<User> data;

    public UserListAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = users;
    }

    public UserListAdapter(Context context, List<User> users) {
        this(context);
        this.data = users;
    }

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

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public User getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.user_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bindView(getItem(position));
        return convertView;
    }

    public class ViewHolder {
        ImageView portrait;
        TextView name;
        TextView desc;

        public ViewHolder(View itemView) {
            name = (TextView) itemView.findViewById(R.id.name);
            desc = (TextView) itemView.findViewById(R.id.desc);
            portrait = (ImageView) itemView.findViewById(R.id.portrait);
        }

        public void bindView(final User user) {
            name.setText(user.getName());
            desc.setText(user.getDesc());
            portrait.setImageResource(user.getPortrait());
        }
    }
}
