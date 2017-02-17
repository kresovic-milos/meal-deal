package com.povio.mealdeal.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.povio.mealdeal.fragments.FragmentFavorites;
import com.povio.mealdeal.fragments.FragmentMain;

/**
 * Created by Kresa on 2/17/17.
 */

public class AdapterTabsMain extends FragmentPagerAdapter {

    private static final int DEALS_FEED = 0;
    private static final int FAVORITE = 1;

    public AdapterTabsMain(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case DEALS_FEED:
                return new FragmentMain();
            case FAVORITE:
                return new FragmentFavorites();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case DEALS_FEED:
                return "DEALS FEED";
            case FAVORITE:
                return "FAVORITE";
        }
        return null;
    }

}
