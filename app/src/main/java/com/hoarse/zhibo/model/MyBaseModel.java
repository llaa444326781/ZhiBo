package com.hoarse.zhibo.model;

import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;

import retrofit2.Retrofit;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/30.
 */

public class MyBaseModel extends BaseModel<IApi> {
    private static final String baseUrl = "http://news-at.zhihu.com/api/4/";
    public MyBaseModel() {
        if(getApi()==null){
            Retrofit retrofit = RetrofitHelper.getRetrofit(baseUrl);
            IApi iApiInterface = retrofit.create(IApi.class);
            setApi(iApiInterface);
        }
    }
}
