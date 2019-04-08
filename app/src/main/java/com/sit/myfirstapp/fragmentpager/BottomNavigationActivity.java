package com.sit.myfirstapp.fragmentpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.sit.myfirstapp.R;

public class BottomNavigationActivity extends AppCompatActivity {

    private Button button;
    private ViewPager pager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                pager.setCurrentItem(0, false);
                return true;
            case R.id.navigation_dashboard:
                pager.setCurrentItem(1, true);
                return true;
            case R.id.navigation_notifications:
                pager.setCurrentItem(2);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        pager = findViewById(R.id.pager);
        button = findViewById(R.id.button);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                button.animate().setDuration(500).xBy(100).yBy(100);

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
