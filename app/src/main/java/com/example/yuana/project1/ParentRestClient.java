package com.example.yuana.project1;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by yuana on 16/10/15.
 */

public class ParentRestClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void cancelAllRequests() {
        client.cancelRequests(null, true);
    }

    public static void cancelAllRequests(Context context) {
        client.cancelRequests(context, true);
    }

    public static void get(String url, RequestParams params,
                           AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return "http://192.168.24.188/belajarandroid/index.php/" + relativeUrl;
        //url_server => 192.168.24.188/belajarandroid/index.php
    }

    public static void post(String url, RequestParams params,
                            AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post_newpass(String url, RequestParams params,
                                    AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }
}
