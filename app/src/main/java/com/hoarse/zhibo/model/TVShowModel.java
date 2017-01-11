package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.TVShowBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/7.
 */

public class TVShowModel extends BaseModel<IApi> implements ITVShowModel {
    private String baseurl = "http://www.quanmin.tv/";

    public TVShowModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }
    @Override
    public void getDataFirst(String path, final MyCallBack<TVShowBean> myCallBack) {
        deploy(getApi().getTVShowData(path), new ICallback<TVShowBean>() {

            @Override
            public void onCompleted(TVShowBean tvShowBean) {
                myCallBack.success(tvShowBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }
}
