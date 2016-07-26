package com.android.lala.http.listener;

import android.content.DialogInterface;

import com.android.lala.base.BaseActivity;
import com.android.lala.customview.WaitDialog;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * @author sxshi on 2016/7/26.
 * @email:emotiona_xiaoshi@126.com
 */
public class HttpResponseListener<T> {
    private BaseActivity mActivity;
    private WaitDialog mWaitDialog;
    private Request<?> mRequest;
    public Response.ErrorListener mErrorListener;
    public Response.Listener<T> mListener;

    public HttpResponseListener(BaseActivity activity, Request<?> request, final HttpListener httpListener, boolean isLoading, boolean canCancel) {
        this.mActivity = activity;
        this.mRequest = request;
        if (activity != null && isLoading) {
            mWaitDialog = new WaitDialog(activity);
            mWaitDialog.setCancelable(canCancel);
            mWaitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mRequest.cancel();
                }
            });
        }
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Class volleyErrorClass = volleyError.getClass();
                String message = null;
                if (volleyErrorClass == com.android.volley.ServerError.class) {
                    message = "服务不可用，请稍后重试!";
                } else if (volleyErrorClass == com.android.volley.AuthFailureError.class) {
                    message = "身份验证未通过，请稍后重试!";
                } else if (volleyErrorClass == com.android.volley.ParseError.class) {
                    message = "解析数据错误，请稍后重试!";
                } else if (volleyErrorClass == com.android.volley.TimeoutError.class) {
                    message = "网络连接超时，请稍后重试！";
                } else if (volleyError instanceof NetworkError) {
                    if (volleyErrorClass == com.android.volley.NoConnectionError.class) {
                        message = "无法连接服务器,请检查网络地址是否正确!";
                    } else {
                        message = "网络连接异常，请检查网络!";
                    }
                } else {
                    message = "重定向错误，请稍后重试!";
                }
                httpListener.onFail(message);
            }
        };
        mListener = new Response.Listener<T>() {
            @Override
            public void onResponse(T t) {
                httpListener.onSuccess(t);
            }
        };
    }

    public void onFinish() {
        if (mWaitDialog != null && mWaitDialog.isShowing())
            mWaitDialog.dismiss();
    }
}
