package com.hoarse.library.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public class RetrofitHelper {
    public static Retrofit getRetrofit(String baseUrl){
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(baseUrl)
                .client(OkHttpHelper.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder.build();
    }

    public static <T> T getService(String baseUrl,Class<T> cls){
        return getRetrofit(baseUrl).create(cls);
    }
}
