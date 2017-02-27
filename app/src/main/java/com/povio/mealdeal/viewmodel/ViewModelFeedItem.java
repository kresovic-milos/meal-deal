package com.povio.mealdeal.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.ui.adapters.AdapterDealsFeed;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.FontCache;
import com.povio.mealdeal.utils.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by Kresa on 2/22/17.
 */

public class ViewModelFeedItem extends BaseObservable {

    private Deal deal;

    public ViewModelFeedItem(Deal deal) {
        this.deal = deal;
    }

    public String getTitle() {
        return deal.getName();
    }

    public String getShortDescription() {
        return deal.getShortDescription();
    }
}
