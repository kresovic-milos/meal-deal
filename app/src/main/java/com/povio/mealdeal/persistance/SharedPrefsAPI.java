package com.povio.mealdeal.persistance;

import android.content.SharedPreferences;

import com.povio.mealdeal.utils.Constants;

import javax.inject.Inject;

/**
 * Created by Kresa on 2/21/17.
 */

public class SharedPrefsAPI {


    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPrefsAPI(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void registerOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public void setIfMapView(boolean isMapView) {
        sharedPreferences.edit().putBoolean(Constants.PrefsKeys.MAP_VIEW, isMapView).apply();
    }

    public boolean isMapView() {
        return sharedPreferences.getBoolean(Constants.PrefsKeys.MAP_VIEW, false);
    }
}
