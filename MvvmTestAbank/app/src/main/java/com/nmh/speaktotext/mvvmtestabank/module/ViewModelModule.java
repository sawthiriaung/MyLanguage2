package com.nmh.speaktotext.mvvmtestabank.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.nmh.speaktotext.mvvmtestabank.ui.login.LoginViewModel;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoItemViewModel;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoListViewModel;
import com.nmh.speaktotext.mvvmtestabank.ui.splash.SplashViewModel;
import com.nmh.speaktotext.mvvmtestabank.utils.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Singleton
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel.class)
    abstract ViewModel bindRepoListViewModel(RepoListViewModel repoListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    abstract RepoItemViewModel bindRepoItemViewModel(RepoItemViewModel viewModel);
}
