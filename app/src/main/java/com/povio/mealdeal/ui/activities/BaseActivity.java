package com.povio.mealdeal.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.povio.mealdeal.viewmodel.BaseViewModel;

/**
 * Created by Kresa on 2/20/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private BaseViewModel viewModel;

    @Nullable
    protected abstract BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseViewModel.State savedViewModelState = null;
        if (savedInstanceState != null) {
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }
        viewModel = createViewModel(savedViewModelState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }

    protected void startChildActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
