package com.povio.mealdeal;

import android.app.Application;
import android.content.Context;

import com.povio.mealdeal.di.components.ComponentMealDeal;

/**
 * Created by Kresa on 2/16/17.
 */

public class AppMealDeal extends Application {

    private ComponentMealDeal componentMealDeal;

    @Override
    public void onCreate() {
        super.onCreate();

        componentMealDeal = createComponent();
    }

    private ComponentMealDeal createComponent() {
        componentMealDeal = ComponentMealDeal.Initializer.init(this);
        componentMealDeal.inject(this);
        return componentMealDeal;
    }

    public ComponentMealDeal getComponent() {
        if (componentMealDeal == null) {
            createComponent();
        }
        return componentMealDeal;
    }

    public static AppMealDeal get(Context context) {
        return (AppMealDeal) context.getApplicationContext();
    }
}
