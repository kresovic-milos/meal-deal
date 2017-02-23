package com.povio.mealdeal.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.povio.mealdeal.R;

/**
 * Created by Kresa on 2/16/17.
 */

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);
        finish();
    }
}
