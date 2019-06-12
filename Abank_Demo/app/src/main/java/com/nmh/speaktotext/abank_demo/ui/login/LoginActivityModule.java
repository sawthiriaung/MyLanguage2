package com.nmh.speaktotext.abank_demo.ui.login;

import com.nmh.speaktotext.abank_demo.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    ViewModelProviderFactory provideLoginViewModelFactory() {
        return new ViewModelProviderFactory();
    }
}
