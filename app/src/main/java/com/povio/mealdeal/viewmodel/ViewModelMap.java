package com.povio.mealdeal.viewmodel;

import android.support.annotation.Nullable;

import com.povio.mealdeal.persistance.SharedPrefsAPI;

import javax.inject.Inject;

/**
 * Created by Kresa on 2/22/17.
 */

public class ViewModelMap extends ViewModelTab {

    @Inject
    SharedPrefsAPI sharedPrefsAPI;

    public ViewModelMap(@Nullable State savedInstanceState) {
        super(savedInstanceState);
    }


}
