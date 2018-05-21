package com.framgia.music_09.data.remote;

import com.framgia.music_09.BuildConfig;
import com.framgia.music_09.data.TrackDataSource;
import com.framgia.music_09.utils.Constant;

public class RemoteDataSource implements TrackDataSource {

    private static TrackDataSource sInstance;

    private RemoteDataSource() {
    }

    public static RemoteDataSource getInstance() {
        if (sInstance == null) {
            synchronized (RemoteDataSource.class) {
                new RemoteDataSource();
            }
        }
        return (RemoteDataSource) sInstance;
    }

    @Override
    public void getTracks(String genreTitle, LoadTrackCallBack callBack) {
        String url = Constant.BASE_URL + '?' + Constant.KeyValues.PARA_MUSIC_GENRE + ':'
                + genreTitle + '&' + Constant.KeyValues.CLIENT_ID + "=" + BuildConfig.API_KEY;
        new LoadAsync(callBack).execute(url);
    }
}
