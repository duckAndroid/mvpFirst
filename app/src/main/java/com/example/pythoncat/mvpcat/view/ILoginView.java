package com.example.pythoncat.mvpcat.view;

import android.support.annotation.NonNull;

import com.example.pythoncat.mvpcat.bean.User;

/**
 * Created  on 17-3-2.
 *
 * @author pythoncat
 */

public interface ILoginView {

    @NonNull
    String getUserName();

    @NonNull
    String getPassword();

    void showLoading();
    void hideLoading();

    void toMainActivity(User user);

    void showLoginFail();

    void clearUserName();

    void clearPassword();
}
