package com.framgia.music_09.data.model;

import android.graphics.Bitmap;

public class Track {
    private int mId;
    private String mTitle;
    private String mUri;
    private String mArtworkUrl;
    private int mDuration;
    private boolean mIsDownloadAble;
    private String mStreamUrl;
    private String mUserName;

    public Track(int id, String title, String uri, boolean isDownloadAble, String userName) {
        mId = id;
        mTitle = title;
        mUri = uri;
        mIsDownloadAble = isDownloadAble;
        mUserName = userName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public Bitmap getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public boolean isDownloadAble() {
        return mIsDownloadAble;
    }

    public void setDownloadAble(boolean downloadAble) {
        mIsDownloadAble = downloadAble;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        mStreamUrl = streamUrl;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }
}
