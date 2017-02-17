package com.povio.mealdeal.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.povio.mealdeal.R;
import com.povio.mealdeal.utils.Constants;

import static android.content.ContentValues.TAG;

/**
 * Created by Kresa on 2/16/17.
 */

public class FragmentFavorites extends Fragment {

    public FragmentFavorites() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Constants.TAG, "new frag fav " + this);
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }
}
