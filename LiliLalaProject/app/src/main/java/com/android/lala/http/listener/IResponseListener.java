package com.android.lala.http.listener;

import com.android.volley.VolleyError;

/**
 * @author sxshi on 2016/7/26.
 * @email:emotiona_xiaoshi@126.com
 * @describe:Describe the function  of the current class
 */
public interface IResponseListener<T>{
    void onSuccess(T t);

    void onFail(VolleyError volleyError);

    void onFinish();
}
