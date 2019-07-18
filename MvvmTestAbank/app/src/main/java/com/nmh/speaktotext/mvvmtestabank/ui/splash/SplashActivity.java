package com.nmh.speaktotext.mvvmtestabank.ui.splash;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.nmh.speaktotext.mvvmtestabank.R;
import com.nmh.speaktotext.mvvmtestabank.base.BaseActivity;
import com.nmh.speaktotext.mvvmtestabank.databinding.ActivitySplashBinding;
import com.nmh.speaktotext.mvvmtestabank.ui.login.LoginActivity;
import com.nmh.speaktotext.mvvmtestabank.utils.ViewModelFactory;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity <ActivitySplashBinding,SplashViewModel> implements SplashNavigator {

    Handler handler;
    @Inject
    ViewModelFactory factory;
    private SplashViewModel splashViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public SplashViewModel getViewModel() {
        splashViewModel = ViewModelProviders.of(this, factory).get(SplashViewModel.class);
        return splashViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel.setNavigator(this);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashViewModel.start();
                finish();
            }
        },3000);

    }

    @Override
    public void openToast(String string) {

    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
        Toast.makeText(this, "This is my Toast message!",
                Toast.LENGTH_LONG).show();

    }
}
