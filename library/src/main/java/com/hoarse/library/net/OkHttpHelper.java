package com.hoarse.library.net;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public class OkHttpHelper {
    private static OkHttpHelper mOkHttpHelper;

    public OkHttpHelper() {
    }

    public static OkHttpHelper getInstance() {
        if (mOkHttpHelper == null) {
            synchronized (OkHttpHelper.class) {
                if (mOkHttpHelper == null) {
                    mOkHttpHelper = new OkHttpHelper();
                }
            }
        }
        return mOkHttpHelper;
    }

    public static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .connectTimeout(3000, TimeUnit.MILLISECONDS);

        List<Interceptor> sList = InterceptorManager.getInterceptorList();
        if (sList.isEmpty()) {

        } else {
            for (Interceptor interceptor : sList) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }
}
