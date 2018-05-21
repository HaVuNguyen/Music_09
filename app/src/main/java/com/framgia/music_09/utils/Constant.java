package com.framgia.music_09.utils;

import com.framgia.music_09.BuildConfig;

public final class Constant {

    public static final String BASE_URL = "https://api-v2.soundcloud.com/";

    public static final class KeyValues {
        public static final String PARA_MUSIC_GENRE = "genres";
        public static final String CLIENT_ID = "client_id=" + BuildConfig.API_KEY;
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String DURATION = "duration";
        public static final String URI = "uri";
        public static final String DOWNLOADABLE = "downloadable";
        public static final String ARTWORK_URL = "artwork_url";
        public static final String STREAM_URL = "stream_url";
        public static final String USER = "user";
        public static final String USERNAME = "username";
    }
}
