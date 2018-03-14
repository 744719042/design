package com.example.design.provider;

import android.app.ActionBar;
import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.design.R;
import com.example.design.utils.CommonUtils;

/**
 * Created by Administrator on 2018/3/14.
 */

public class FileActionProvider extends ActionProvider {
    /**
     * Creates a new instance. ActionProvider classes should always implement a
     * constructor that takes a single Context parameter for inflating from menu XML.
     *
     * @param context Context for accessing resources.
     */
    public FileActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        final ImageView imageView = new ImageView(getContext());
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(CommonUtils.dp2px(30), CommonUtils.dp2px(30));
        imageView.setLayoutParams(params);
        imageView.setImageResource(R.drawable.peach);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), imageView);
                popupMenu.inflate(R.menu.sub_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.action_new) {
                            Toast.makeText(getContext(), "新建文件", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        return imageView;
    }

    @Override
    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        super.onPrepareSubMenu(subMenu);
//        subMenu.clear();
//        subMenu.add("新建文件").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(getContext(), "新建文件", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        subMenu.add("打开文件").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(getContext(), "打开文件", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        subMenu.add("删除文件").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(getContext(), "删除文件", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }
}
