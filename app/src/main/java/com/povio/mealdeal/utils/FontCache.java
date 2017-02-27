package com.povio.mealdeal.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.povio.mealdeal.R;

import java.util.HashMap;

/**
 * Created by Kresa on 2/18/17.
 */

public class FontCache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = fontCache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontname);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            fontCache.put(fontname, typeface);
        }

        return typeface;
    }

    public static void setTypeface(TextView textView, int position, boolean isThick) {

        String font;

        switch (position % 2) {
            case 0:
                font = isThick ? Constants.Font.THICK_1 : Constants.Font.SKINNY_1;
                break;
            case 1:
                font = isThick ? Constants.Font.THICK_2 : Constants.Font.SKINNY_2;
                break;
            default:
                font = isThick ? Constants.Font.THICK_1 : Constants.Font.SKINNY_1;
        }

        textView.setTypeface(FontCache.getTypeface(font, textView.getContext()));
    }
}
