package com.example.design.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.design.R;
import com.example.design.model.User;

/**
 * Created by Administrator on 2018/2/1.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageView portrait;
    private TextView name;
    private TextView desc;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        desc = (TextView) itemView.findViewById(R.id.desc);
        portrait = (ImageView) itemView.findViewById(R.id.portrait);
    }


    public void bindView(User user) {
        name.setText(user.getName());
        desc.setText(user.getDesc());
        portrait.setImageResource(user.getPortrait());
    }
}