package com.android.locbookapp.ui.timetable;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.bus.Bus;
import com.android.locbookapp.ui.cab.Cab;
import com.android.locbookapp.ui.metro.Metro;
import com.android.locbookapp.ui.mono.Mono;
import com.android.locbookapp.ui.registration.ViewPagerAdapter;
import com.android.locbookapp.ui.trains.Train;
import com.google.android.material.tabs.TabLayout;

public class TimeTableActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.title_activity_timetable);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Train(), "");
        viewPagerAdapter.addFragment(new Bus(), "");
        viewPagerAdapter.addFragment(new Metro(), "");
        viewPagerAdapter.addFragment(new Mono(), "");
        viewPagerAdapter.addFragment(new Cab(), "");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.viewpager_tab);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.local_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.bus_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.metro_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.mono_icon);
        tabLayout.getTabAt(4).setIcon(R.drawable.cab_icon);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#263238"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) ;
        finish();
        return super.onOptionsItemSelected(item);
    }
}