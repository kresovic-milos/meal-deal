package com.povio.mealdeal.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.povio.mealdeal.R;
import com.povio.mealdeal.viewmodel.BaseViewModel;
import com.povio.mealdeal.viewmodel.ViewModelAbout;

/**
 * Created by Kresa on 2/16/17.
 */

public class ActivityAbout extends ToolbarActivity {

    private ViewModelAbout viewModelAbout;

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState) {
        viewModelAbout = new ViewModelAbout(savedViewModelState);
        return viewModelAbout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.string.about);
        setContentView(R.layout.activity_about);
    }
}
