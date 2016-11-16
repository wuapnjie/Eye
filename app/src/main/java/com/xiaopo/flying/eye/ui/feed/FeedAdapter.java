package com.xiaopo.flying.eye.ui.feed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaopo.flying.eye.R;
import com.xiaopo.flying.eye.model.entity.Feed;
import com.xiaopo.flying.eye.util.Format;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by snowbean on 16-11-16.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {
    private static final String TAG = "FeedAdapter";

    private List<Feed> mData;

    @Override
    public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feed, parent, false);
        return new FeedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedHolder holder, int position) {
        Feed feed = mData.get(position);
        if (feed != null) {
            holder.mTvTitle.setText(feed.data.title);
            Picasso.with(holder.itemView.getContext())
                    .load(feed.data.cover.feed)
                    .fit()
                    .centerInside()
                    .into(holder.mIvCover);

            holder.mTvInfo.setText("# " + feed.data.category + " / " + Format.formatDuration(feed.data.duration));
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void refreshData(List<Feed> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public static class FeedHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover)
        ImageView mIvCover;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_info)
        TextView mTvInfo;

        public FeedHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
