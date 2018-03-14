package com.example.design.provider;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.design.R;

/**
 * Created by Administrator on 2018/3/14.
 */

public class UploadActionProvider extends ActionProvider {
    private int count = 0;
    private TextView mTxtCount;
    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public UploadActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.upload_layout, null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext().getApplicationContext(), "正在下载中...", Toast.LENGTH_SHORT).show();
                setCount(++count);
            }
        });
        mTxtCount = (TextView) view.findViewById(R.id.download_count);
        return view;
    }

    public void setCount(int count) {
        if (mTxtCount != null) {
            mTxtCount.setText(String.valueOf(count));
        }
    }
}
