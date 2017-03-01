package com.example.pythoncat.mvpcat.biz;

import android.support.annotation.NonNull;

import com.example.pythoncat.mvpcat.bean.User;

/**
 * Created  on 17-3-2.
 * @author pythoncat
 */

public interface OnLoginListener {

    void loginSuccess(@NonNull User user);
    void loginFail();
}
