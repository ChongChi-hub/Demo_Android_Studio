package com.ptit.viewpagernnavigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewpagerAdater adapter = new ViewpagerAdater(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override public void onPageScrolled(int position, float offset, int pixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0: mBottomNavigationView.getMenu().findItem(R.id.person).setChecked(true); break;
                    case 1: mBottomNavigationView.getMenu().findItem(R.id.home).setChecked(true); break;
                    case 2: mBottomNavigationView.getMenu().findItem(R.id.settings).setChecked(true); break;
                }
            }

            @Override public void onPageScrollStateChanged(int state) {}
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.person) {
                    mViewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.home) {
                    mViewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.settings) {
                    mViewPager.setCurrentItem(2);
                }
                return true;
            }
        });
    }
}