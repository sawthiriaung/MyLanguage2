package com.nmh.speaktotext.mvvmtestabank.ui.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nmh.speaktotext.mvvmtestabank.BR;
import com.nmh.speaktotext.mvvmtestabank.R;
import com.nmh.speaktotext.mvvmtestabank.base.BaseActivity;
import com.nmh.speaktotext.mvvmtestabank.databinding.ActivityLoginBinding;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoListActivity;
import com.nmh.speaktotext.mvvmtestabank.utils.ViewModelFactory;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements
        LoginNavigator{

    @Inject
    ViewModelFactory factory;
    ActivityLoginBinding loginLayoutBinding;
    private LoginViewModel loginViewModel;
    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
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
        loginViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel.class);
        return loginViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginLayoutBinding = getViewDataBinding();
        showFragment();
        loginViewModel.password.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i("Change password",s);
                loginViewModel.password.setValue(s);

            }
        });
    }

    private void showFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.screenContainer, LoginFragment.newInstance(), LoginFragment.TAG)
                .commit();
    }

    @Override
    public void showToast(String name, String password) {
        Toast.makeText(this, "User Name !"+name+" Password !"
                +password, Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void gotoUserListActivity() {
        Intent intent =  intent.putExtra("User", loginViewModel.getU());
        intent.putExtra("Password", loginViewModel.getP());
        startActivity(intent);
        finish();
        UserListActivity.newIntent(LoginActivity.this);
    }*/

    @Override
    public void gotoRepoListActivity() {
        Intent intent = RepoListActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }
}
