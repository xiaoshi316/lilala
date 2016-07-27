package com.android.lala.http;

import android.content.Context;
import android.content.DialogInterface;

import com.android.lala.R;
import com.android.lala.base.BaseActivity;
import com.android.lala.customview.WaitDialog;
import com.android.lala.http.listener.HttpListener;
import com.android.lala.utils.LalaLog;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxshi
 */
public class RequestFactory {
    private static final int DEFAULT_TIME_OUT = 20 * 1000;
    private static volatile RequestFactory mFactory;
    private Context mContext;

    private RequestFactory(BaseActivity activity) {
        mWaitDialog = new WaitDialog(activity);
        mContext = activity.getApplicationContext();
    }

    public static RequestFactory getInstance(BaseActivity activity) {
        if (null == mFactory) {
            synchronized (RequestFactory.class) {
                if (null == mFactory) {
                    mFactory = new RequestFactory(activity);
                }
            }
        }
        return mFactory;
    }

    private static WaitDialog mWaitDialog;

    public Request<String> createStringRequest(final int what, String url, final HttpListener<String> httpListener, final HashMap<String, String> paramers, boolean isLoading) {
        LalaLog.i("url:", url);
        showProgress(isLoading);
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dismiss();
                LalaLog.i(response);
                httpListener.onSuccess(what, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                dismiss();
                Class volleyErrorClass = volleyError.getClass();
                String message = "未知异常";
                if (volleyErrorClass == com.android.volley.ServerError.class) {
                    message = mContext.getString(R.string.network_server_error);
                } else if (volleyErrorClass == com.android.volley.AuthFailureError.class) {
                    message = mContext.getString(R.string.network_author_error);
                } else if (volleyErrorClass == com.android.volley.ParseError.class) {
                    message = mContext.getString(R.string.network_parser_error);
                } else if (volleyErrorClass == com.android.volley.TimeoutError.class) {
                    message = mContext.getString(R.string.network_timeout_error);
                } else if (volleyError instanceof NetworkError) {
                    if (volleyErrorClass == com.android.volley.NoConnectionError.class) {
                        message = mContext.getString(R.string.network_connect_error);
                    } else {
                        message = mContext.getString(R.string.network_nomarl_error);
                    }
                } else {
                    message = mContext.getString(R.string.network_red_error);
                }
                LalaLog.i("error:", message);
                httpListener.onFail(message);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                LalaLog.i("paramers:", paramers.toString());
                if (paramers.size() > 0)
                    return paramers;
                else {
                    return super.getParams();
                }
            }
        };
        mWaitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                stringRequest.cancel();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(DEFAULT_TIME_OUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        return stringRequest;
    }

    private static void showProgress(boolean isLoading) {
        if (isLoading && !mWaitDialog.isShowing()) {
            mWaitDialog.setCanceledOnTouchOutside(false);
            mWaitDialog.show();
        }
    }

    private static void dismiss() {
        if (mWaitDialog != null && mWaitDialog.isShowing())
            mWaitDialog.dismiss();
    }
}
