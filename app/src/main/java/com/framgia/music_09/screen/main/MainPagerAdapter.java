package com.framgia.music_09.screen.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.music_09.R;
import com.framgia.music_09.screen.home.HomeFragment;
import com.framgia.music_09.screen.office.OfficeFragment;
import com.framgia.music_09.screen.search.SearchFragment;
import com.framgia.music_09.utils.TabLayout;
import java.util.ArrayList;
import java.util.List;

import static com.framgia.music_09.utils.TabLayout.TAB_HOME;
import static com.framgia.music_09.utils.TabLayout.TAB_OFFICE;
import static com.framgia.music_09.utils.TabLayout.TAB_SEARCH;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private static final int TAB_COUNT = 3;
    private Context mContext;
    private List<Fragment> mFragmentList;

    MainPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
        mFragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TabLayout.TAB_HOME:
                return HomeFragment.newInstance();
            case TabLayout.TAB_OFFICE:
                return OfficeFragment.newInstance();
            case TabLayout.TAB_SEARCH:
                return SearchFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case TAB_HOME:
                return mContext.getString(R.string.tab_home);
            case TAB_OFFICE:
                return mContext.getString(R.string.my_music);
            case TAB_SEARCH:
                return mContext.getString(R.string.tab_search);
            default:
                break;
        }
        return null;
    }
}
