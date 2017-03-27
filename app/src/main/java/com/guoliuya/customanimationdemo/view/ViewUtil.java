package com.guoliuya.customanimationdemo.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 控件绘制所需要的一些工具方法
 * Created by LiFZhe on 4/11/16.
 */
public class ViewUtil {

    public static float dp2Px(Context context, int dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }

    public static float getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getScreenDp(Context context){
        return (int)(getScreenWidth(context)/getDensity(context));
    }
    public static float getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
