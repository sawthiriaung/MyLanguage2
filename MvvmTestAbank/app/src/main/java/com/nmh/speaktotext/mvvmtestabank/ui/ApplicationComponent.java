package com.nmh.speaktotext.mvvmtestabank.ui;

import android.app.Application;

import com.nmh.speaktotext.mvvmtestabank.base.BaseApplication;
import com.nmh.speaktotext.mvvmtestabank.module.ActivityBindingModule;
import com.nmh.speaktotext.mvvmtestabank.module.ApplicationModule;
import com.nmh.speaktotext.mvvmtestabank.module.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}
