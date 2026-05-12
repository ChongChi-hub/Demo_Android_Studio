package com.ptit.viewpagernavigation;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewpageAdapter viewpageAdapter = new ViewpageAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );
        mViewPager.setAdapter(viewpageAdapter);

        mViewPager.setCurrentItem(0);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Person");
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.person).setChecked(true);
                        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Person");
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Home");
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.settings).setChecked(true);
                        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Setting");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.person) {
                    mViewPager.setCurrentItem(0);
                    if (getSupportActionBar() != null) getSupportActionBar().setTitle("Person");
                } else if (id == R.id.home) {
                    mViewPager.setCurrentItem(1);
                    if (getSupportActionBar() != null) getSupportActionBar().setTitle("Home");
                } else if (id == R.id.settings) {
                    mViewPager.setCurrentItem(2);
                    if (getSupportActionBar() != null) getSupportActionBar().setTitle("Setting");
                }
                return true;
            }
        });
    }
}