package com.android.lala.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.lala.R;
import com.android.lala.api.ApiContacts;
import com.android.lala.base.BaseActivity;
import com.android.lala.http.VolleyHelper;
import com.android.lala.http.listener.BaseVolleyErrorListener;
import com.android.lala.http.request.ByteRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText mUserName;
    private EditText mPassWord;
    private TextView ForgotPwd;
    private Button btn_login;
    private Button btn_reg;

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
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_login) {
            HashMap<String, String> paramers = new HashMap<>();
            ByteRequest byteRequest = new ByteRequest(ApiContacts.USER_LOGIN, new Response.Listener<byte[]>() {
                @Override
                public void onResponse(byte[] bytes) {

                }
            }, new BaseVolleyErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    super.onErrorResponse(volleyError);
                }
            });
            byteRequest.setParamers(paramers);
            VolleyHelper.getInstance().add(byteRequest);
        }
    }
}
