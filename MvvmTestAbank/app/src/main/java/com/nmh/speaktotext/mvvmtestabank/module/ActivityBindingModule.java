package com.nmh.speaktotext.mvvmtestabank.module;

import com.nmh.speaktotext.mvvmtestabank.ui.login.LoginActivity;
import com.nmh.speaktotext.mvvmtestabank.ui.login.LoginModule;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoListActivity;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoListModule;
import com.nmh.speaktotext.mvvmtestabank.ui.splash.SplashActivity;
import com.nmh.speaktotext.mvvmtestabank.ui.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = RepoListModule.class)
    abstract RepoListActivity bindRepoActivity();
}
