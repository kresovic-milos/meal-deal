package com.povio.mealdeal.ui.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.povio.mealdeal.ui.fragments.FragmentDealsFeed;
import com.povio.mealdeal.ui.fragments.FragmentDealsMap;

/**
 * Created by Kresa on 2/17/17.
 */

public class AdapterTabsMain extends FragmentPagerAdapter {

    public static final int TAB_FEED = 0;
    public static final int TAB_MAP = 1;

    public AdapterTabsMain(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case TAB_FEED:
                return new FragmentDealsFeed();
            case TAB_MAP:
                return new FragmentDealsMap();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case TAB_FEED:
                return "FEED";
            case TAB_MAP:
                return "MAP";
        }
        return null;
    }
}
