package com.xiaopo.flying.eye.util;

import android.support.annotation.NonNull;

import com.google.android.agera.Observable;
import com.google.android.agera.Repositories;
import com.google.android.agera.RepositoryCompilerStates;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by snowbean on 16-11-16.
 */
public class Ageras {
    private Ageras() {

    }

    private static class LazyLoad {
        static final Executor networkExecutor = Executors.newSingleThreadExecutor();
    }


    @NonNull
    public static Executor getNetworkSingleThreadExecutor() {
        return LazyLoad.networkExecutor;
    }

    public static <T> RepositoryCompilerStates.RFlow<T, T, ?> goToNetworkExecutorWithInitialValue(
            final T initialValue) {
        return Repositories.repositoryWithInitialValue(initialValue)
                .observe()
                .onUpdatesPerLoop()
                .goTo(getNetworkSingleThreadExecutor());

    }

    public static <T> RepositoryCompilerStates.RFlow<T, T, ?> goToNetworkExecutorWithInitialValue(
            final T initialValue, Observable... observables) {
        return Repositories.repositoryWithInitialValue(initialValue)
                .observe(observables)
                .onUpdatesPerLoop()
                .goTo(getNetworkSingleThreadExecutor());

    }
}
