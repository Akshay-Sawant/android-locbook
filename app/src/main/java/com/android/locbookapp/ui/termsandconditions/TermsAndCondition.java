package com.android.locbookapp.ui.termsandconditions;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.policy.Policy;
import com.android.locbookapp.ui.registration.ViewPagerAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class TermsAndCondition extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    private SmartTabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Terms and Policy");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Terms(), "Terms  &  Condition");
        viewPagerAdapter.addFragment(new Policy(), "Privacy  Policy");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (SmartTabLayout) findViewById(R.id.viewpager_tab);

        tabLayout.setViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) ;
        finish();
        return super.onOptionsItemSelected(item);
    }
}