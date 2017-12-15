package com.sf.tinker.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class ActivityUtil {
    /**
     * 强制设置横屏
     * @param context
     */
    public static void setScreenOrientationPortrait(Activity context) {
        if (context.getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    /**
     * 强制设置竖屏
     * @param context
     */
    public static void setScreenOrientationLandscape(Activity context) {
        if (context.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
