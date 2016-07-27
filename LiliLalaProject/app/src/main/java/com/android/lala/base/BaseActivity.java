package com.android.lala.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.android.lala.R;
import com.android.lala.http.VolleyHelper;

import java.util.HashMap;


/**
 * @author ssx
 */
public abstract class BaseActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private FrameLayout mContentLayout;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDelegate().setContentView(R.layout.activity_base);
        VolleyHelper.getInstance().init(this);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContentLayout = (FrameLayout) findViewById(R.id.content);
        setSupportActionBar(mToolbar);
        setBackBar(true);
        if (!isShowToolBar()) {
            getSupportActionBar().hide();
        }
        onActivityCreate(savedInstanceState);
        initListener();
    }

    protected abstract void initListener();

    protected abstract boolean isShowToolBar();

    protected abstract void onActivityCreate(Bundle savedInstanceState);

    public <T extends View> T findView(int viewId) {
        return (T) mContentLayout.findViewById(viewId);
    }

    public CoordinatorLayout getCoordinatorLayout() {
        return mCoordinatorLayout;
    }

    public FrameLayout getContentLayout() {
        return mContentLayout;
    }

    public AppBarLayout getAppBarLayout() {
        return mAppBarLayout;
    }

    public Toolbar getmToolbar() {
        return mToolbar;
    }

    @Override
    public void setTitle(CharSequence title) {
        mToolbar.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        mToolbar.setTitle(titleId);
    }

    public void setSubtitle(CharSequence title) {
        mToolbar.setSubtitle(title);
    }

    public void setSubtitle(int titleId) {
        mToolbar.setSubtitle(titleId);
    }

    public void setSubtitleTextColor(int color) {
        mToolbar.setSubtitleTextColor(color);
    }

    public void setTitleTextColor(int color) {
        mToolbar.setTitleTextColor(color);
    }

    public void setBackBar(boolean isShow) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(isShow);
    }

    public void setContentBackground(int color) {
        mContentLayout.setBackgroundResource(color);
    }

    @Override
    public void setContentView(int layoutResID) {
        mContentLayout.removeAllViews();
        getLayoutInflater().inflate(layoutResID, mContentLayout, true);
    }

    @Override
    public void setContentView(View view) {
        mContentLayout.removeAllViews();
        mContentLayout.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContentLayout.addView(view, params);
    }

    @Override
    public final boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return onOptionsItemSelectedCompat(item);
    }

    protected boolean onOptionsItemSelectedCompat(MenuItem item) {
        return false;
    }

    public ViewGroup getContentRoot() {
        return mContentLayout;
    }

    /**
     * Show message dialog.
     *
     * @param title   title.
     * @param message message.
     */
    public void showMessageDialog(int title, int message) {
        showMessageDialog(getText(title), getText(message));
    }

    /**
     * Show message dialog.
     *
     * @param title   title.
     * @param message message.
     */
    public void showMessageDialog(int title, CharSequence message) {
        showMessageDialog(getText(title), message);
    }

    /**
     * Show message dialog.
     *
     * @param title   title.
     * @param message message.
     */
    public void showMessageDialog(CharSequence title, int message) {
        showMessageDialog(title, getText(message));
    }

    /**
     * Show message dialog.
     *
     * @param title   title.
     * @param message message.
     */
    public void showMessageDialog(CharSequence title, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void request(String url, final HashMap<String, String> paramers) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
