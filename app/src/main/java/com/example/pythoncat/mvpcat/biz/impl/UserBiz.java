package com.example.pythoncat.mvpcat.biz.impl;

import android.os.SystemClock;
import android.support.annotation.NonNull;

import com.example.pythoncat.mvpcat.bean.User;
import com.example.pythoncat.mvpcat.biz.IUserBiz;
import com.example.pythoncat.mvpcat.biz.OnLoginListener;

/**
 * Created  on 17-3-2.
 * @author pythoncat
 */

public class UserBiz implements IUserBiz{


    @Override
    public void login(@NonNull final String userName,
                      @NonNull final String password,
                      @NonNull final OnLoginListener listener)  {

        // 模拟耗时操作


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(userName.equals("pythoncat") && password.equals("123")){

                    User u = new User();
                    u.userName = userName;
                    u.password = password;
                    listener.loginSuccess(u);
                }else {
                    listener.loginFail();
                }

            }
        }).start();

    }
}
