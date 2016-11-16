package com.xiaopo.flying.eye.model;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;
import com.xiaopo.flying.eye.model.entity.Daily;

import retrofit2.http.GET;

/**
 * Created by snowbean on 16-11-13.
 */
public interface EyeService{
    @GET("v2/feed?num=1")
    Supplier<Result<Daily>> fetchDaily();
}
