package com.framgia.music_09.screen.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.framgia.music_09.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView mTextAllMusic;
    private TextView mTextYoungMusic;
    private TextView mTextUsMusic;
    private TextView mTextEdmMusic;
    private TextView mTextAcousticMusic;
    private TextView mTextKoreanMusic;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mTextAllMusic = view.findViewById(R.id.text_all_music);
        mTextAcousticMusic = view.findViewById(R.id.text_acoustic_music);
        mTextEdmMusic = view.findViewById(R.id.text_edm_music);
        mTextKoreanMusic = view.findViewById(R.id.text_korean_music);
        mTextUsMusic = view.findViewById(R.id.text_us_music);
        mTextYoungMusic = view.findViewById(R.id.text_young_music);

        mTextAllMusic.setOnClickListener(this);
        mTextYoungMusic.setOnClickListener(this);
        mTextUsMusic.setOnClickListener(this);
        mTextKoreanMusic.setOnClickListener(this);
        mTextEdmMusic.setOnClickListener(this);
        mTextAcousticMusic.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_all_music:
                Toast.makeText(getContext(), R.string.music_all, Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_young_music:
                Toast.makeText(getContext(), R.string.music_young, Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_edm_music:
                Toast.makeText(getContext(), R.string.music_edm, Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_us_music:
                Toast.makeText(getContext(), R.string.music_us, Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_acoustic_music:
                Toast.makeText(getContext(), R.string.music_acoustic, Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_korean_music:
                Toast.makeText(getContext(), R.string.music_korean, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
