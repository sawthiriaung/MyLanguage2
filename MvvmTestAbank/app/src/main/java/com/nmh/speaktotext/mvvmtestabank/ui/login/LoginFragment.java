package com.nmh.speaktotext.mvvmtestabank.ui.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.nmh.speaktotext.mvvmtestabank.BR;
import com.nmh.speaktotext.mvvmtestabank.R;
import com.nmh.speaktotext.mvvmtestabank.base.BaseFragment;
import com.nmh.speaktotext.mvvmtestabank.databinding.ActivityLoginBinding;
import com.nmh.speaktotext.mvvmtestabank.ui.repo.RepoListActivity;
import com.nmh.speaktotext.mvvmtestabank.utils.ViewModelFactory;

import javax.inject.Inject;

public class LoginFragment  extends BaseFragment<ActivityLoginBinding,LoginViewModel> implements LoginNavigator {

    @Inject
    ViewModelFactory factory;
    private LoginViewModel loginViewModel;

    public static final String TAG = LoginFragment.class.getSimpleName();
    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
       return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_frag;
    }

    @Override
    public LoginViewModel getViewModel() {
        loginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return loginViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel.setNavigator(this);
        loginViewModel.password.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i("Change password",s);


            }
        });
    }

    @Override
    public void showToast(String username, String password) {
        Toast.makeText(getActivity(), "User Name !"+username+" Password !"+password,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void gotoRepoListActivity() {
        Intent intent = RepoListActivity.newIntent(getContext());
        startActivity(intent);
    }
}
