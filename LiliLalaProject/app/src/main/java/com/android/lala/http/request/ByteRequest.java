package com.android.lala.http.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

/***
 * @category
 * 重写Request 返回byte[]数组 
 * @author sxshi
 */
public class ByteRequest extends Request<byte[]> {
	private Listener<byte[]> mListener;

	public ByteRequest(int method, String url, Listener<byte[]> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		this.mListener = listener;
	}

	public ByteRequest(String url, Listener<byte[]> listener, ErrorListener errorListener) {
		super(0, url, errorListener);
	}

	@Override
	protected void deliverResponse(byte[] response) {
		// TODO Auto-generated method stub
		if (this.mListener != null) {
			this.mListener.onResponse(response);
		}
	}
	@Override
	protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {
		byte[] result=response.data;
		return Response.success(result, HttpHeaderParser.parseCacheHeaders(response));
	}
}
