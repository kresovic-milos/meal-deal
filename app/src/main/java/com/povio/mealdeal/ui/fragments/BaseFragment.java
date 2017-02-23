package com.povio.mealdeal.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.povio.mealdeal.viewmodel.BaseViewModel;

/**
 * Created by Kresa on 2/21/17.
 */

public abstract class BaseFragment extends Fragment {

    private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private BaseViewModel viewModel;

    @Nullable
    protected abstract BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BaseViewModel.State savedViewModelState = null;
        if (savedInstanceState != null) {
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }
        viewModel = createViewModel(savedViewModelState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }
}
