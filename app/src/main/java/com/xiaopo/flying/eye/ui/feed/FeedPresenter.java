package com.xiaopo.flying.eye.ui.feed;

import com.google.android.agera.Observable;
import com.google.android.agera.Receiver;
import com.google.android.agera.Repository;
import com.google.android.agera.Result;
import com.xiaopo.flying.eye.base.AgeraPresenter;
import com.xiaopo.flying.eye.model.EyeApi;
import com.xiaopo.flying.eye.model.entity.Daily;
import com.xiaopo.flying.eye.util.Ageras;

/**
 * Created by snowbean on 16-11-16.
 */
public class FeedPresenter extends AgeraPresenter implements FeedContract.Presenter {
    private static final String TAG = "FeedPresenter";

    private final FeedContract.View mView;
    private final Repository<Result<Daily>> mRepository;

    private Receiver<Daily> mDailyReceiver;

    public FeedPresenter(FeedContract.View view, Observable... observables) {
        mView = view;
        mRepository = Ageras
                .goToNetworkExecutorWithInitialValue(Result.<Daily>absent(), observables)
                .attemptGetFrom(EyeApi.INSTANCE.fetchDaily())
                .orEnd(Result::failure)
                .thenTransform(Result::success)
                .compile();

        mDailyReceiver = value -> mView.refreshFeed(value.issueList.get(0).itemList);
    }

    @Override
    public void start() {
        mRepository.addUpdatable(this);
    }

    @Override
    public void end() {
        mRepository.removeUpdatable(this);
    }

    @Override
    public void update() {
        mRepository.get()
                .ifSucceededSendTo(mDailyReceiver)
                .ifFailedSendTo(mErrorReceiver);
    }
}
