package com.povio.mealdeal.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.Nullable;

import com.povio.mealdeal.entities.Deal;

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
