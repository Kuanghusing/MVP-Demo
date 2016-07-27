package com.kuahusg.v2exwithmvp.Util;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by kuahusg on 16-7-25.
 */
public class StatusBarUtil {
    public static final String STATUS = "StatusBarUtil";
    public static void setupStatusBar(FrameLayout layout, int color, Activity activity) {
        Log.v(STATUS, "SDK_INT:" + Build.VERSION.SDK_INT + "VERSION_CODES:" + Build.VERSION_CODES.M);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup.LayoutParams params = layout.getLayoutParams();
            params.height = activity.getResources().getDimensionPixelOffset(activity.getResources()
                    .getIdentifier("status_bar_height", "dimen", "android"));
            Log.v(STATUS, "height:" + params.height);
            layout.setBackgroundColor(color);
        }

    }
}
