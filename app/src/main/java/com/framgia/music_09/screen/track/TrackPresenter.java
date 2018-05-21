package com.framgia.music_09.screen.track;

import com.framgia.music_09.data.TrackDataSource;
import com.framgia.music_09.data.TracksRepository;
import com.framgia.music_09.data.model.Track;
import java.util.List;

public class TrackPresenter implements TrackContract.Presenter, TrackDataSource.LoadTrackCallBack {

    private final TrackContract.View mView;
    private TracksRepository mTracksRepository;

    public TrackPresenter(TracksRepository tracksRepository, TrackContract.View view){
        mView =view;
        mView.setPresenter(this);
        mTracksRepository = tracksRepository;
    }

    @Override
    public void onTracksLoaded(List<Track> tracks) {
        mView.showTracks(tracks);
    }

    @Override
    public void onDataNotAvailable() {
        mView.showError();
    }

    @Override
    public void getTracks(String genreTitle) {
        mTracksRepository.getTracks(genreTitle,this);
    }

    @Override
    public void start() {

    }
}
