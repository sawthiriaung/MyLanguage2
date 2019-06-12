package com.nmh.speaktotext.abank_demo.ui.login;

import android.text.TextUtils;

import com.nmh.speaktotext.abank_demo.base.BaseViewModel;
import com.nmh.speaktotext.abank_demo.utils.CommonUtils;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel() {
        super();
    }

//    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
//        if (TextUtils.isEmpty(email)) {
//            return false;
//        }
//        if (!CommonUtils.isEmailValid(email)) {
//            return false;
//        }
//        if (TextUtils.isEmpty(password)) {
//            return false;
//        }
//        return true;
//    }

    public void onServerLoginClick() {
        getNavigator().login();
    }
}
