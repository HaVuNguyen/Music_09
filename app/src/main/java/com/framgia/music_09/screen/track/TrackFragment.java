package com.framgia.music_09.screen.track;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.framgia.music_09.R;
import com.framgia.music_09.data.model.Track;
import com.framgia.music_09.utils.Constant;
import java.util.List;

public class TrackFragment extends Fragment implements View.OnClickListener {

    private TextView mTextTrack;
    private Button mButtonBack;
    private RecyclerView mRecyclerView;
    private TrackContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_track, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mTextTrack = getView().findViewById(R.id.text_track_music);
        mButtonBack = getView().findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(this);
        mRecyclerView = getView().findViewById(R.id.recycler_view_track_music);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int genreTitle = bundle.getInt(Constant.KeyValues.ARGUMENT_GENRE_NAME);
            mTextTrack.setText(getString(genreTitle));
            mPresenter.getTracks(getGenreKeyWord(genreTitle));
        }
    }

    private String getGenreKeyWord(int genreTitle) {
        switch (genreTitle) {
            case R.string.music_all:
                return Constant.KeyValues.ALL_MUSIC;
            case R.string.music_young:
                return Constant.KeyValues.YOUNG_MUSIC;
            case R.string.music_edm:
                return Constant.KeyValues.EDM_MUSIC;
            case R.string.music_us:
                return Constant.KeyValues.US_MUSIC;
            case R.string.music_acoustic:
                return Constant.KeyValues.ACOUSTIC_MUSIC;
            case R.string.music_korean:
                return Constant.KeyValues.KOREAN_MUSIC;
            default:
                return null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                getActivity().getSupportFragmentManager().popBackStackImmediate();
                break;
            default:
                break;
        }
    }

    public void showTrack(List<Track> tracks) {
        TrackAdapter adapter = new TrackAdapter(getActivity());
        adapter.updateData(tracks);
        adapter.setOnRecyclerViewItemClickListener(
                (TrackAdapter.OnRecyclerViewItemClickListener) this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
    }
}
