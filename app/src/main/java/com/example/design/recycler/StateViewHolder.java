package com.example.design.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.design.R;
import com.example.design.model.User;

/**
 * Created by Administrator on 2018/2/1.
 */

public class StateViewHolder extends RecyclerView.ViewHolder {
    private TextView text;
    public StateViewHolder(View itemView) {
        super(itemView);
        this.text = (TextView) itemView.findViewById(R.id.text);
    }

    public void bindView(User user) {
        text.setText(user.getName());
    }
}
