package com.android.lala.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.lala.R;
import com.android.lala.api.ApiContacts;
import com.android.lala.api.HttpWhatContacts;
import com.android.lala.base.BaseActivity;
import com.android.lala.http.RequestFactory;
import com.android.lala.http.VolleyHelper;
import com.android.lala.http.listener.HttpListener;
import com.android.volley.Request;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText mUserName;
    private EditText mPassWord;
    private TextView ForgotPwd;
    private Button btn_login;
    private Button btn_reg;

    private String username;
    private String pwd;
    private HttpListener<String> httpListener;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        VolleyHelper.getInstance().init(this);
        mUserName = findView(R.id.lg_username);
        mPassWord = findView(R.id.lg_password);
        btn_login = findView(R.id.btn_login);
        btn_reg = findView(R.id.btn_reg);
    }

    @Override
    protected void initListener() {
        btn_login.setOnClickListener(this);
        httpListener = new HttpListener<String>() {
            @Override
            public void onSuccess(int what, String response) {

            }

            @Override
            public void onFail(String errMsg) {
                showMessageDialog("提示", errMsg);
            }
        };
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_login) {
            username = mUserName.getText().toString().trim();
            pwd = mPassWord.getText().toString().trim();
            HashMap<String, String> paramers = new HashMap<>();
            paramers.put("name", username);
            paramers.put("pw", pwd);
            Request<String> request = RequestFactory.getInstance(this).createStringRequest(HttpWhatContacts.LOGIN, ApiContacts.USER_LOGIN, httpListener, paramers, true);
            VolleyHelper.getInstance().add("login", request);
        } else if (viewId == R.id.btn_reg) {

        }
    }

    @Override
    protected boolean isShowToolBar() {
        return false;
    }
}
