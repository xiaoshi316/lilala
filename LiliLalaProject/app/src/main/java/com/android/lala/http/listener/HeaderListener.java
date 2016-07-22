package com.android.lala.http.listener;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sxshi on 2016/6/16.
 * @email:emotiona_xiaoshi@126.com
 * @describe:网络请求头封装，用户可以根据自己的需求封装请求头
 */
public interface HeaderListener {
    /***
     * 添加请求头信息
     * @return
     */
    Hashtable<String, String> addRequestHeader();
    /***
     * （解析/获取）请求头信息
     * @param headers
     * @return
     */
    Hashtable<String, String> getResponseHeader(Map<String, String> headers);
}
