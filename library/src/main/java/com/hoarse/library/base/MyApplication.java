package com.hoarse.library.base;

import android.app.Application;
import android.content.Context;

import com.hoarse.library.net.InterceptorManager;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public class MyApplication extends Application {
    private String baseUrl = "";
    private static MyApplication sMyApplication;
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication=this;
        sContext=this;
        initOkHttp();
    }

    private void initOkHttp() {
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        InterceptorManager.add(loggingInterceptor);
    }
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static MyApplication getMyApplication() {
        return sMyApplication;
    }

    public static Context getContext() {
        return sContext;
    }
}
