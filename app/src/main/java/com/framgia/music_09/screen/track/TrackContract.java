package com.framgia.music_09.screen.track;

import com.framgia.music_09.data.model.Track;
import com.framgia.music_09.screen.BasePresenter;
import com.framgia.music_09.screen.BaseView;
import java.util.List;

public interface TrackContract {
    interface View extends BaseView<Presenter> {
        void showTracks(List<Track> tracks);

        void showError();
    }

    interface Presenter extends BasePresenter {
        void getTracks(String genreTitle);
    }
}