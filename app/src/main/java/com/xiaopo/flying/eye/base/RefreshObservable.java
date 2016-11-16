package com.xiaopo.flying.eye.base;

import android.support.v4.widget.SwipeRefreshLayout;

import com.google.android.agera.BaseObservable;

/**
 * Created by snowbean on 16-11-16.
 */
public class RefreshObservable extends BaseObservable implements SwipeRefreshLayout.OnRefreshListener {

    @Override
    public void onRefresh() {
        dispatchUpdate();
    }
}
