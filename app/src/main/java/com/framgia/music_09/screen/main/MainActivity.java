package com.framgia.music_09.screen.main;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.framgia.music_09.R;
import java.util.Objects;

import static com.framgia.music_09.utils.TabLayout.TAB_HOME;
import static com.framgia.music_09.utils.TabLayout.TAB_OFFICE;
import static com.framgia.music_09.utils.TabLayout.TAB_SEARCH;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ViewPager pager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout_main);
        FragmentManager manager = getSupportFragmentManager();

        PagerAdapter adapter = new PagerAdapter(this, manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(adapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(tabLayout.getTabAt(TAB_HOME)).setIcon(R.drawable.ic_home);
            Objects.requireNonNull(tabLayout.getTabAt(TAB_OFFICE)).setIcon(R.drawable.ic_person);
            Objects.requireNonNull(tabLayout.getTabAt(TAB_SEARCH)).setIcon(R.drawable.ic_search);
        }
    }
}
