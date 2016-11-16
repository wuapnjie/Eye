package com.xiaopo.flying.eye.util;

import java.util.Locale;

/**
 * Created by snowbean on 16-11-16.
 */
public class Format {
    public static String formatDuration(int duration) {
        return String.format(Locale.CHINA, "%02d' %02d\"", duration / 60, duration % 60);
    }
}
