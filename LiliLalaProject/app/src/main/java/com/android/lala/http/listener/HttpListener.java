package com.android.lala.http.listener;

public interface HttpListener<T> {
    /***
     * @param response
     * @return
     */
    void onSuccess(T response);

    /***
     * @param errMsg
     */
    void onFail(String errMsg);
}
