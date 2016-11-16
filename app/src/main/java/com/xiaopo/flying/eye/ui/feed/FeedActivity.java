package com.xiaopo.flying.eye.ui.feed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.xiaopo.flying.eye.R;
import com.xiaopo.flying.eye.base.RefreshObservable;
import com.xiaopo.flying.eye.model.entity.Feed;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedActivity extends AppCompatActivity implements FeedContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.feed_list)
    RecyclerView mFeedList;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    private FeedContract.Presenter mPresenter;
    private FeedAdapter mFeedAdapter;
    private RefreshObservable mRefreshObservable = new RefreshObservable();

    @Override
    public void setPresenter(FeedContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        initView();

        setPresenter(new FeedPresenter(this, mRefreshObservable));

    }

    private void initView() {
        mFeedAdapter = new FeedAdapter();
        mFeedList.setLayoutManager(new LinearLayoutManager(this));
        mFeedList.setAdapter(mFeedAdapter);

        mRefresh.setOnRefreshListener(mRefreshObservable);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRefresh();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.end();
    }


    @Override
    public void refreshFeed(List<Feed> feeds) {
        mFeedAdapter.refreshData(feeds);
        dismissRefresh();
    }

    public void showRefresh() {
        mRefresh.post(() -> mRefresh.setRefreshing(true));
    }

    public void dismissRefresh() {
        mRefresh.post(() -> mRefresh.setRefreshing(false));
    }
}
