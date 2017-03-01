package com.example.pythoncat.mvpcat.biz;

import android.support.annotation.NonNull;

/**
 * Created on 17-3-2.
 * @author pythoncat
 */

public interface IUserBiz {

    void login(@NonNull String userName,@NonNull String password,@NonNull OnLoginListener listener);
}
