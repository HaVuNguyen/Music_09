package com.framgia.music_09.screen.track;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.framgia.music_09.R;
import com.framgia.music_09.data.model.Track;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Track> mTracks = new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public TrackAdapter(Context context) {
        mContext = context;
    }

    public void setOnRecyclerViewItemClickListener(
            OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_track, parent, false);
        return new TrackViewHolder(view, mOnRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        TrackViewHolder trackViewHolder = (TrackViewHolder) holder;
        trackViewHolder.fillData(mTracks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTracks != null ? mTracks.size() : 0;
    }

    public void updateData(List<Track> tracks) {
        if (tracks == null) {
            return;
        }
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(Track track);
    }

    private class TrackViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageTrack;
        private TextView mTextNameSong;
        private TextView mTextNameSing;
        private Track mTrack;
        private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

        public TrackViewHolder(View itemView,
                OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            mImageTrack = itemView.findViewById(R.id.image_track);
            mTextNameSong = itemView.findViewById(R.id.text_name_song);
            mTextNameSing = itemView.findViewById(R.id.text_name_sing);
            mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRecyclerViewItemClickListener.onItemClick(mTrack);
                }
            });
        }

        public void fillData(Track track) {
            if (track == null) {
                return;
            }
            mTrack = track;
            mTextNameSong.setText(track.getTitle());
            mTextNameSing.setText(track.getUserName());
//            Picasso.with(mContext)
//                    .load(track.getArtworkUrl())
//                    .error(R.mipmap.ic_launcher)
//                    .into(mImageTrack);
            mImageTrack.setImageBitmap(track.getArtworkUrl());
        }
    }
}
