package com.povio.mealdeal.viewmodel;

import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.povio.mealdeal.R;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.utils.FontCache;
import com.povio.mealdeal.utils.ImageLoader;

/**
 * Created by Kresa on 2/23/17.
 */

public class ViewModelDetails extends BaseViewModel {

    private Deal deal;

    public ViewModelDetails(@Nullable State savedInstanceState, Deal deal) {
        super(savedInstanceState);
        this.deal = deal;
    }

    public String getTitle() {
        return deal.getName();
    }

    public String getShortDescription() {
        return deal.getShortDescription();
    }

    public String getDealPhotoUrl() {
        return deal.getPhotoUrl();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(final ImageView imageView, final String imageUrl) {
        ImageLoader.loadImage(imageView, imageUrl);
    }
}
