package com.example.pythoncat.mvpcat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pythoncat.mvpcat.bean.User;
import com.example.pythoncat.mvpcat.presenter.UserPresenter;
import com.example.pythoncat.mvpcat.view.ILoginView;

/**
 * 模拟用户登录的操作
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar pb;
    private TextView tvError;
    private UserPresenter presenter;
    private View layoutData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new UserPresenter(this);
        initViews();
    }

    private void initViews() {
        layoutData = findViewById(R.id.layout_data);
        etUserName = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnClear = (Button) findViewById(R.id.btn_clear);
        pb = (ProgressBar) findViewById(R.id.pb_main);
        tvError = (TextView) findViewById(R.id.tv_error);
        pb.setVisibility(View.GONE);
        tvError.setVisibility(View.GONE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(getWindow()
                            .getDecorView().getWindowToken(), 0);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    @NonNull
    @Override
    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    @NonNull
    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
        layoutData.setVisibility(View.GONE);
        tvError.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        layoutData.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
        tvError.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(getApplicationContext(), "to mainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFail() {
        Toast.makeText(getApplicationContext(), "login fail", Toast.LENGTH_SHORT).show();
        tvError.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
        tvError.setText(R.string.error);
    }

    @Override
    public void clearUserName() {
        etUserName.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }
}
