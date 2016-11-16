package com.xiaopo.flying.eye.base;

import android.util.Log;

import com.google.android.agera.Receiver;

/**
 * Created by snowbean on 16-11-16.
 */
public class AgeraPresenter {
    private static final String TAG = AgeraPresenter.class.getSimpleName();
    protected Receiver<Throwable> mErrorReceiver =
            value -> Log.e(TAG, "error : " + value.getMessage(), value);
}
