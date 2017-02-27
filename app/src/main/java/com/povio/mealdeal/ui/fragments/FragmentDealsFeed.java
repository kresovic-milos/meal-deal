package com.povio.mealdeal.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.povio.mealdeal.R;
import com.povio.mealdeal.databinding.FragmentDealsFeedBinding;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.ToggleFavListener;
import com.povio.mealdeal.viewmodel.BaseViewModel;
import com.povio.mealdeal.viewmodel.ViewModelDealsFeed;

/**
 * Created by Kresa on 2/16/17.
 */

public class FragmentDealsFeed extends BaseFragment implements ToggleFavListener {

    private ViewModelDealsFeed viewModelDealsFeed;
    private FragmentDealsFeedBinding binding;

    public FragmentDealsFeed() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Constants.TAG, "new frag feed " + this);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_deals_feed, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setViewModel(viewModelDealsFeed);
        binding.setFragmentContext(this);

        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        binding.swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(Constants.TAG, "frag feed onRefresh()");
                viewModelDealsFeed.refresh();
            }
        });
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState) {
        viewModelDealsFeed = new ViewModelDealsFeed(savedViewModelState, this, getActivity());
        return viewModelDealsFeed;
    }

    @Override
    public void onToggle(Fragment fragment) {
        viewModelDealsFeed.toggleFav();
    }
}
