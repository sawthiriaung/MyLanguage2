package com.nmh.speaktotext.mvvmtestabank.ui.splash;

import com.nmh.speaktotext.mvvmtestabank.base.BaseViewModel;

import javax.inject.Inject;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    @Inject
    public SplashViewModel() {


    }
    public void start(){

        getNavigator().openLoginActivity();

    }
}
