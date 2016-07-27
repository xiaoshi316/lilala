package com.android.lala.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.lala.R;
import com.android.lala.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private ImageView cross;
    private EditText et_phone;
    private EditText et_code;
    private Button btn_getcode;
    private Button btn_next;
    private Button btn_relogin;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        cross = findView(R.id.cross);
        et_phone = findView(R.id.et_phone);
        et_code = findView(R.id.et_code);
        btn_getcode = findView(R.id.btn_getcode);
        btn_next = findView(R.id.btn_next);
        btn_relogin = findView(R.id.btn_relogin);
    }

    @Override
    protected void initListener() {
        btn_relogin.setOnClickListener(this);
        btn_getcode.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    @Override
    protected boolean isShowToolBar() {
        return false;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btn_getcode) {

        }
    }
}
