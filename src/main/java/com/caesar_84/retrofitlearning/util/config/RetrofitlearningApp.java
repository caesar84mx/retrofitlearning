package com.caesar_84.retrofitlearning.util.config;

import android.app.Application;

import lombok.Getter;

/**
 * Created by Gabe on 9/13/18.
 */

public class RetrofitlearningApp extends Application {

    @Getter
    private GlobalConfigComponent globalConfigComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        globalConfigComponent = DaggerGlobalConfigComponent.builder()
                .globalConfigModule(new GlobalConfigModule())
                .build();
    }
}
