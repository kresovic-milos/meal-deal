package com.povio.mealdeal.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Kresa on 2/24/17.
 */

public class ImageLoader {

    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).crossFade().into(imageView);

        //        centerCrop().placeholder(R.drawable.loading_spinner)
    }
}
