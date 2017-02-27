package com.povio.mealdeal.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;
import com.povio.mealdeal.R;
import com.povio.mealdeal.databinding.FragmentDealsMapBinding;
import com.povio.mealdeal.viewmodel.BaseViewModel;
import com.povio.mealdeal.viewmodel.ViewModelMap;

/**
 * Created by Kresa on 2/16/17.
 */

public class FragmentDealsMap extends BaseFragment {

    private ViewModelMap viewModelMap;
    private FragmentDealsMapBinding binding;

    public FragmentDealsMap() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_deals_map, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setViewModel(viewModelMap);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map_map);
        mapFragment.getMapAsync(viewModelMap);
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState) {
        viewModelMap = new ViewModelMap(savedViewModelState, getActivity());
        return viewModelMap;
    }
}