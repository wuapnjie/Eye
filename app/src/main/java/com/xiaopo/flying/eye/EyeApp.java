package com.xiaopo.flying.eye;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;

/**
 * Created by snowbean on 16-11-13.
 */
public class EyeApp extends Application {
    private static final String TAG = "EyeApp";

    @Override
    public void onCreate() {
        super.onCreate();

        initPicasso();
    }

    private void initPicasso() {
        Picasso picasso = new Picasso.Builder(this)
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .downloader(new OkHttp3Downloader(this))
                .listener((picasso1, uri, exception) ->
                        Log.e(TAG, "onImageLoadFailed: Uri --> " + uri.toString(), exception))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
