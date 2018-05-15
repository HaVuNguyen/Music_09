package com.framgia.music_09.data;

import com.framgia.music_09.data.remote.RemoteDataSource;

public class TracksRepository implements TrackDataSource {

    private static TracksRepository sInstance;
    private RemoteDataSource mTrackRemoteDataSource;

    private TracksRepository(RemoteDataSource remoteDataSource) {
        mTrackRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getTracks(String genreTitle, LoadTrackCallBack callBack) {
        if (mTrackRemoteDataSource != null) {
            mTrackRemoteDataSource.getTracks(genreTitle, callBack);
        }
    }
}
