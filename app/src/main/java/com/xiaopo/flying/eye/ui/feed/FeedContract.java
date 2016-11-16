package com.xiaopo.flying.eye.ui.feed;

import com.xiaopo.flying.eye.base.BasePresenter;
import com.xiaopo.flying.eye.base.BaseView;
import com.xiaopo.flying.eye.model.entity.Feed;

import java.util.List;

/**
 * Created by snowbean on 16-11-16.
 */

public interface FeedContract {
    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {
        void refreshFeed(List<Feed> feeds);
    }
}
