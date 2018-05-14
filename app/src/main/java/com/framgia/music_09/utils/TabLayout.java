package com.framgia.music_09.utils;

import android.support.annotation.IntDef;

import static com.framgia.music_09.utils.TabLayout.TAB_HOME;
import static com.framgia.music_09.utils.TabLayout.TAB_OFFICE;
import static com.framgia.music_09.utils.TabLayout.TAB_SEARCH;

@IntDef({ TAB_HOME, TAB_OFFICE, TAB_SEARCH })
public @interface TabLayout {
    int TAB_HOME = 0;
    int TAB_OFFICE = 1;
    int TAB_SEARCH = 2;
}
