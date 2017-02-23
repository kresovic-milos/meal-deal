package com.povio.mealdeal.viewmodel;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.ToggleFavListener;

/**
 * Created by Kresa on 2/23/17.
 */

public abstract class ViewModelTab extends BaseViewModel implements SharedPreferences.OnSharedPreferenceChangeListener {

    public ToggleFavListener toggleFavListener;

    protected ViewModelTab(@Nullable State savedInstanceState) {
        super(savedInstanceState);
    }

    public void toggleFav() {
        Log.d(Constants.TAG, "ViewModelContainer.toggleFav()");
        //TODO filter fav
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals(Constants.PrefsKeys.MAP_VIEW)) {
            Log.d(Constants.TAG, "ViewModelContainer.onSharedPreferenceChanged()");
            toggleFav();
        }
    }
}
