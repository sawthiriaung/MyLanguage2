package com.nmh.speaktotext.abank_demo.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nmh.speaktotext.abank_demo.BR;
import com.nmh.speaktotext.abank_demo.R;
import com.nmh.speaktotext.abank_demo.base.BaseActivity;
import com.nmh.speaktotext.abank_demo.databinding.ActivityLoginBinding;
import com.nmh.speaktotext.abank_demo.ui.main.MainActivity;
import com.nmh.speaktotext.abank_demo.utils.ViewModelProviderFactory;

import javax.inject.Inject;


public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements
        LoginNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void login() {
        String email = mActivityLoginBinding.etEmail.getText().toString();
        String password = mActivityLoginBinding.etPassword.getText().toString();
//        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
//            hideKeyboard();
//            mLoginViewModel.login(email, password);
//        } else {
//            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
//        }
    }



    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }
}
