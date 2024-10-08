package com.hsm.tourguideapp;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPaper(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPaper(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        OverviewFragment overviewFragment = new OverviewFragment();
        HotelsFragment hotelsFragment = new HotelsFragment();
        RestaurantsFragment restaurantsFragment = new RestaurantsFragment();
        CafesFragment cafesFragment = new CafesFragment();
        HospitalsFragment hospitalsFragment = new HospitalsFragment();

        adapter.addFragment(overviewFragment, overviewFragment.tag);
        adapter.addFragment(hotelsFragment, hotelsFragment.tag);
        adapter.addFragment(restaurantsFragment, restaurantsFragment.tag);
        adapter.addFragment(cafesFragment, cafesFragment.tag);
        adapter.addFragment(hospitalsFragment, hospitalsFragment.tag);
        viewPager.setAdapter(adapter);
    }
}
