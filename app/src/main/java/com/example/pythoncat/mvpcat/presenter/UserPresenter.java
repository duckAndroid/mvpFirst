package com.example.pythoncat.mvpcat.presenter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.inputmethod.InputMethodManager;

import com.example.pythoncat.mvpcat.bean.User;
import com.example.pythoncat.mvpcat.biz.IUserBiz;
import com.example.pythoncat.mvpcat.biz.OnLoginListener;
import com.example.pythoncat.mvpcat.biz.impl.UserBiz;
import com.example.pythoncat.mvpcat.view.ILoginView;

/**
 * Created on 17-3-2.
 *
 * @author pythoncat
 */

public class UserPresenter {

    private IUserBiz userBiz;

    private ILoginView loginView;

    private Handler mHandler = new Handler();

    public UserPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(@NonNull final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFail() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showLoginFail();
                        loginView.hideLoading();
                    }
                });
            }
        });

    }

    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }
}
