package com.xiaopo.flying.eye.model;

import android.util.Log;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;
import com.xiaopo.flying.eye.model.entity.Daily;

import java.util.concurrent.TimeUnit;

import me.drakeet.retrofit2.adapter.agera.AgeraCallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by snowbean on 16-11-13.
 */
public enum EyeApi implements EyeDataSource {
    INSTANCE {
        @Override
        public Supplier<Result<Daily>> fetchDaily() {
            return mEyeService.fetchDaily();
        }
    };

    private static String BASE_URL = "http://baobab.wandoujia.com/api/";
    private static EyeService mEyeService;

    static {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Log.d("OkHttp", "log: " + message));
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(AgeraCallAdapterFactory.create())
                .build();

        mEyeService = retrofit.create(EyeService.class);
    }

}
