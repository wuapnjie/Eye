package com.xiaopo.flying.eye.base;

/**
 * Created by snowbean on 16-11-16.
 */
public interface BaseView <T extends BasePresenter>{
    void setPresenter(T presenter);
}
