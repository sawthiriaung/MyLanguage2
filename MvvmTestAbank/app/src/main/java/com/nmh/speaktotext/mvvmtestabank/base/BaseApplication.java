package com.nmh.speaktotext.mvvmtestabank.base;

import com.nmh.speaktotext.mvvmtestabank.ui.ApplicationComponent;
import com.nmh.speaktotext.mvvmtestabank.ui.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}
