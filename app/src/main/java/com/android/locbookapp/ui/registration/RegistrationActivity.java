package com.android.locbookapp.ui.registration;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.signin.Signin;
import com.android.locbookapp.ui.signup.Signup;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class RegistrationActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    CoordinatorLayout coordinatorLayout;
    Context context;
    public String Username;
    public String Userid;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Signin(), "Sign in");
        viewPagerAdapter.addFragment(new Signup(), "Sign up");
        viewPager.setAdapter(viewPagerAdapter);

        smartTabLayout = (SmartTabLayout) findViewById(R.id.viewpager_tab);
        smartTabLayout.setViewPager(viewPager);
    }
}