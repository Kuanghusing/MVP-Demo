package com.kuahusg.v2exwithmvp.Util;

import android.app.Activity;
import android.os.Build;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by kuahusg on 16-7-25.
 */
public class StatusBarUtil {
    public static void setupStatusBar(FrameLayout layout, int color, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup.LayoutParams params = layout.getLayoutParams();
            params.height = activity.getResources().getDimensionPixelOffset(activity.getResources()
                    .getIdentifier("status_bar_height", "dimen", "android"));
            layout.setBackgroundColor(color);
        }

    }
}
