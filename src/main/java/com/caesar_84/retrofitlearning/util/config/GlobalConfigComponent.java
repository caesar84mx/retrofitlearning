package com.caesar_84.retrofitlearning.util.config;

import com.caesar_84.retrofitlearning.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gabe on 9/13/18.
 */

@Component(modules = {GlobalConfigModule.class})
@Singleton
public interface GlobalConfigComponent {
    void inject(MainActivity mainActivity);
}
