package com.povio.mealdeal.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.povio.mealdeal.R;
import com.povio.mealdeal.databinding.ActivityDetailsBinding;
import com.povio.mealdeal.databinding.ActivityMainBinding;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.utils.FontCache;
import com.povio.mealdeal.viewmodel.BaseViewModel;
import com.povio.mealdeal.viewmodel.ViewModelDetails;

import org.parceler.Parcels;

/**
 * Created by Kresa on 2/17/17.
 */

public class ActivityDealDetails extends ToolbarActivity {

    private ViewModelDetails viewModelDetails;

    private ActivityDetailsBinding binding;

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState) {
        viewModelDetails = new ViewModelDetails(savedViewModelState, (Deal) Parcels.unwrap(getIntent().getParcelableExtra("deal")));
        return viewModelDetails;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        binding.setViewModel(viewModelDetails);

        setUpActionBar(R.string.details);

        setFont(getIntent().getIntExtra("position", 0));
    }

    private void setFont(int position) {
        FontCache.setTypeface(binding.textviewDealTitle, position, true);
        FontCache.setTypeface(binding.textviewShortDescription, position, false);
    }
}
