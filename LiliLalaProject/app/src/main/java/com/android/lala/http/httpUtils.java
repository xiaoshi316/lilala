package com.android.lala.http;

import com.android.lala.http.listener.NetEngineListener;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sxshi on 2016/6/15.
 * @email:emotiona_xiaoshi@126.com
 * @describe:httpUtils
 */
public class httpUtils {
    private static final int Time_Out = 60 * 1000;
    private String sessionID;
    public static httpUtils httpUtils = null;

    public static httpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new httpUtils();
        }
        return httpUtils;
    }

    /***
     * @param requestQueue
     * @param url
     * @param params
     * @param netEngineListener
     */
    public void doVolleyPost(RequestQueue requestQueue, final String url, final Hashtable<String, String> params, final NetEngineListener netEngineListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
