package com.sit.myfirstapp.fragmentpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PagerFragment.getInstance("Home fragment", "#7C4DFF");
            case 1:
                return PagerFragment.getInstance("Dashboard fragment", "#fa4a4e");
            case 2:
                return PagerFragment.getInstance("Notifications fragment", "#66d4ff");
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
