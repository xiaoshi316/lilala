package com.android.lala.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.lala.LaLaAppaction;
import com.android.lala.R;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Hashtable;

/**
 * Created by ssx .
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected boolean mIsMainPage = false; // 首页时判断按两次返回键退出
    public String TAG = this.getClass().getSimpleName();
    public RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (LaLaAppaction.isUseHTTPS) {
//            InputStream keyStore = context.getResources().openRawResource(R.raw.handpayssl);
//            requestQueue = Volley.newRequestQueue(context, new ExtHttpClientStack(new SslHttpClient(keyStore, "handpay", 443)));
        } else {
            requestQueue = Volley.newRequestQueue(this);
        }
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public abstract void initData();

    public abstract void initView();

    public abstract void initListener();

    public abstract int getLayoutId();

    @Override
    public void onBackPressed() {
        finish();
    }

    /***
     * 初始化ToolBar
     *
     * @param toolbar
     * @param leftBackIcon  是否显示左边返回按钮
     * @param rightIcon     是否显示右边设置按钮
     * @param rightListener 右边按钮监听事件
     */
    protected void initToolbar(String title, Toolbar toolbar, boolean leftBackIcon, boolean rightIcon, View.OnClickListener rightListener) {
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_title);
        TextView mSetting = (TextView) toolbar.findViewById(R.id.tv_setting);
        toolbar.setTitle("");
        if (!TextUtils.isEmpty(title)) {
            mTitle.setText(title);
        } else {
            mTitle.setText("");//未设置Fragement title
        }
        // TODO: 是否显示左边返回按钮
        if (leftBackIcon) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        // TODO:  是否显示右边设置文字，并且添加OnClick点击事件
        if (rightIcon) {
            mSetting.setVisibility(View.VISIBLE);
            mSetting.setOnClickListener(rightListener);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(leftBackIcon);
    }

    /***
     * 初始化 ToolBar
     *
     * @param toolbar
     * @param leftBackIcon 左边返回按钮是否显示
     */
    protected void initToolbar(String title, Toolbar toolbar, boolean leftBackIcon) {
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_title);
        TextView mSetting = (TextView) toolbar.findViewById(R.id.tv_setting);
        toolbar.setTitle("");
        if (!TextUtils.isEmpty(title)) {
            mTitle.setText(title);
        } else {
            mTitle.setText("");//未设置Fragement title
        }
        if (leftBackIcon) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        mSetting.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(leftBackIcon);

    }

    /***
     * 初始化 ToolBar
     *
     * @param toolbar
     * @param leftBackIcon 左边返回按钮是否显示
     * @param listener     自定义左边按钮监听
     */
    protected void initToolbar(String title, Toolbar toolbar, boolean leftBackIcon, View.OnClickListener listener) {
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_title);
        TextView mSetting = (TextView) toolbar.findViewById(R.id.tv_setting);
        toolbar.setTitle("");
        if (!TextUtils.isEmpty(title)) {
            mTitle.setText(title);
        } else {
            mTitle.setText("");//未设置Fragement title
        }
        setSupportActionBar(toolbar);
        if (leftBackIcon) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(listener);
        }
        mSetting.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(leftBackIcon);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /***
     * @param action
     * @param params
     * @return
     */
    public void doPost(final String action, final Hashtable<String, String> params, final boolean loading) {

    }

    /***
     * @param action
     * @param params
     * @param loading
     * @param loadingStr
     */
    public void doPost(final String action, final Hashtable<String, String> params, final boolean loading, String loadingStr) {

    }
    /***
     * 网络请求抽象方法处理相关请求回调业务 子类必须实现
     * @param action
     * @param resp
     */
//    public abstract void netResponse(String action, Hashtable<String, Object> resp);

    /***
     * 有网络请求的界面需要实现此方法
     * （考虑到一些界面不需要所以不用抽象方法）
     *
     * @param action
     * @param resp
     */
    public void doNetReponse(String action, Hashtable<String, Object> resp) {
        // TODO: 2016/6/16 处理网络回调业务，
    }

}
