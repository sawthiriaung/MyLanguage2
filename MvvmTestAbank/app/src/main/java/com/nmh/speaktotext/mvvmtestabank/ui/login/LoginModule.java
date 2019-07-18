package com.nmh.speaktotext.mvvmtestabank.ui.login;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @ContributesAndroidInjector
    abstract LoginFragment provideLoginFragment();
}
