package com.povio.mealdeal.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.R;
import com.povio.mealdeal.networking.RequestCompleteListener;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.RequestType;
import com.povio.mealdeal.viewmodel.BaseViewModel;
import com.povio.mealdeal.viewmodel.ViewModelMap;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kresa on 2/16/17.
 */

public class FragmentDealsMap extends BaseFragment {

    private ViewModelMap viewModelMap;

    @Inject
    RESTClientRetrofit2 restClient;

    public FragmentDealsMap() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Constants.TAG, "new frag map " + this);

        return inflater.inflate(R.layout.fragment_deals_map, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppMealDeal) getActivity().getApplication()).getComponent().inject(this);

        getAllDeals();
    }

    private void getAllDeals() {

        restClient.fireRequest(RequestType.GET_ALL_DEALS, null, new RequestCompleteListener() {


            @Override
            public void onSuccess(Object response) {
                Log.d(Constants.TAG, "success " + ((List) response).size());
            }

            @Override
            public void onFailure(String message) {
                Log.d(Constants.TAG, "onFailure " + message);
            }

            @Override
            public void onError(String message) {
                Log.d(Constants.TAG, "onError " + message);
            }
        });
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState) {
        viewModelMap = new ViewModelMap(savedViewModelState);
        return viewModelMap;
    }
}
