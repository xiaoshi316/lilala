package com.android.lala.http.listener;

import java.util.Hashtable;

public interface NetEngineListener
{
	/***
	 * 网络请求成功回调接口
	 * @param action
	 * @param response
     * @return
     */
	  void onSuccess(String action, Hashtable<String, Object> response);

	/***
	 * 网络请求失败的时候回调
	 * @param action
	 * @param resp
     */
	void onFail(String action, Hashtable<String, Object> resp);
}
