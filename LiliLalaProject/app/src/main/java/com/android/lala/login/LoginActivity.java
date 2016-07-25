package com.android.lala.login;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.lala.R;
import com.android.lala.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private EditText lg_username;
    private EditText lg_password;
    private TextView forgotpasswordtext;
    private Button btn_login;
    private Button btn_reg;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

}
