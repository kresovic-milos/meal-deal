package com.povio.mealdeal.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.povio.mealdeal.R;

/**
 * Created by Kresa on 2/22/17.
 */

public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar toolbar;

    protected void setUpActionBar(int titleResId) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(titleResId);
            //getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.blackboard_small));
        }
    }
}
