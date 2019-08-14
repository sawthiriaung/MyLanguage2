package com.xan.mylanguage;

import android.app.Application;
import android.content.Context;

import com.xan.mylanguage.Helper.LocaleHelper;

import java.util.Locale;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
