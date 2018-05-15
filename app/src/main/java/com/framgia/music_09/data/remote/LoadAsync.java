package com.framgia.music_09.data.remote;

import android.os.AsyncTask;
import com.framgia.music_09.data.TrackDataSource;
import com.framgia.music_09.data.model.Track;
import com.framgia.music_09.utils.Constant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadAsync extends AsyncTask<String, Void, String> {
    private TrackDataSource.LoadTrackCallBack mCallBack;

    public LoadAsync(TrackDataSource.LoadTrackCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected String doInBackground(String... strings) {
        return getJsonStringFromURL(strings[0]);
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        if (json == null) {
            mCallBack.onDataNotAvailable();
            return;
        }
        mCallBack.onTracksLoaded(getUserFromJsonString(json));
    }

    private List<Track> getUserFromJsonString(String json) {
        List<Track> tracks = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectTrack = jsonArray.optJSONObject(i);
                int id = jsonObjectTrack.optInt(Constant.KeyValues.ID);
                String title = jsonObjectTrack.optString(Constant.KeyValues.TITLE);
                int duration = jsonObjectTrack.optInt(Constant.KeyValues.DURATION);
                String uri = jsonObjectTrack.optString(Constant.KeyValues.URI);
                boolean isDowloadAble = jsonObjectTrack.optBoolean(Constant.KeyValues.DOWNLOADABLE);
                String artworkUrl = jsonObjectTrack.optString(Constant.KeyValues.ARTWORK_URL);
                String streamUrl = jsonObjectTrack.optString(Constant.KeyValues.STREAM_URL);
                JSONObject objectUser = jsonObjectTrack.optJSONObject(Constant.KeyValues.USER);
                String userName = objectUser.optString(Constant.KeyValues.USERNAME);
                Track track = new Track(id, title, uri, isDowloadAble, userName);
                track.setArtworkUrl(artworkUrl);
                track.setDuration(duration);
                track.setStreamUrl(streamUrl);
                tracks.add(track);
            }
            return tracks;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getJsonStringFromURL(String urls) {
        try {
            URL url = new URL(urls);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder stringBuilder = new StringBuilder();
            boolean line;
            while (line = bufferedReader.readLine() != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            String jsonString = stringBuilder.toString();
            connection.disconnect();
            return jsonString;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
