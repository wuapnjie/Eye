package com.xiaopo.flying.eye.model;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;
import com.xiaopo.flying.eye.model.entity.Daily;

/**
 * Created by snowbean on 16-11-13.
 */
public interface EyeDataSource {
    Supplier<Result<Daily>> fetchDaily();
}
