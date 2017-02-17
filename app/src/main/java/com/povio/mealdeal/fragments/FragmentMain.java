package com.povio.mealdeal.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.povio.mealdeal.R;
import com.povio.mealdeal.utils.Constants;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentMain extends Fragment {

    public FragmentMain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Constants.TAG, "new frag main " + this);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
