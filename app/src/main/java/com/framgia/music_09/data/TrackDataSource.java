package com.framgia.music_09.data;

import com.framgia.music_09.data.model.Track;
import java.util.List;

public interface TrackDataSource {

    void getTracks(String genreTitle, LoadTrackCallBack callBack);

    interface LoadTrackCallBack {
        void onTracksLoaded(List<Track> tracks);

        void onDataNotAvailable();
    }
}
