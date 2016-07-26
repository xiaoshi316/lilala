/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.lala.http;

import android.content.Context;

import com.android.lala.LaLaAppaction;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/***
 * @author ssx
 */
public class VolleyHelper {

    private RequestQueue requestQueue = null;

    private static volatile VolleyHelper instance = null;

    private VolleyHelper() {
    }

    public static VolleyHelper getInstance() {
        if (null == instance) {
            synchronized (VolleyHelper.class) {
                if (null == instance) {
                    instance = new VolleyHelper();
                }
            }
        }
        return instance;
    }

    /**
     * init volley helper
     *
     * @param context
     */
    public void init(Context context) {
        if (LaLaAppaction.isUseHTTPS) {
//            InputStream keyStore = context.getResources().openRawResource(R.raw.handpayssl);
//            requestQueue = Volley.newRequestQueue(context, new ExtHttpClientStack(new SslHttpClient(keyStore, "handpay", 443)));
        } else {
            requestQueue = Volley.newRequestQueue(context);
        }
    }

    public void add(Request<?> request) {
        if (requestQueue!=null){
            requestQueue.add(request);
        }else {
            throw new IllegalArgumentException("RequestQueue is not initialized,please check your BaseActivity's onCreate!");
        }
    }

    /**
     * get request queue
     *
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (null != requestQueue) {
            return requestQueue;
        } else {
            throw new IllegalArgumentException("RequestQueue is not initialized,please check your BaseActivity's onCreate!");
        }
    }
}
