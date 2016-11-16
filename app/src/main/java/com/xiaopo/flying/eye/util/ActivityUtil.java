package com.xiaopo.flying.eye.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by snowbean on 16-11-16.
 */
public class ActivityUtil {
    private ActivityUtil() {

    }

    public static void jumpTo(Activity activity) {
        jumpTo(activity, null);
    }

    public static void jumpTo(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
