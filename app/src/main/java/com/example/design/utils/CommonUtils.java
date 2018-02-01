package com.example.design.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.design.Application;


/**
 * Created by Administrator on 2018/1/17.
 */

public class CommonUtils {
    private static int screenWidth;
    private static int screenHeight;
    private static int statusBarHeight;
    private static int navigationBarHeight;

    public static Context getApplicationContext() {
        return Application.getContext();
    }

    public static void init(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        statusBarHeight = getStatusBarHeight();
        navigationBarHeight = getNavigationBarHeight();
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    /**
     * @return 读取系统的状态栏高度，如果读取错误则取24dp
     */
    public static int getStatusBarHeight() {
        if (statusBarHeight > 0) {
            return statusBarHeight;
        }
        try {
            int result = dp2px(24);
            int resourceId = getApplicationContext()
                    .getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = getApplicationContext()
                        .getResources().getDimensionPixelSize(resourceId);
            }
            return result;
        } catch (Throwable t) {
            return dp2px(24);
        }
    }

    /**
     * @return 读取系统的导航栏高度（如果不存在返回0）
     */
    public static int getNavigationBarHeight() {
        if (navigationBarHeight > 0) {
            return navigationBarHeight;
        }
        try {
            int result = 0;
            int resourceId = getApplicationContext()
                    .getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = getApplicationContext()
                        .getResources().getDimensionPixelSize(resourceId);
            }
            return result;
        } catch (Throwable t) {
            return 0;
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
