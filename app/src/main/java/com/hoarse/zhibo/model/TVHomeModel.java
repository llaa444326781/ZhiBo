package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.TVHomeBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/6.
 */

public class TVHomeModel extends BaseModel<IApi> implements ITVHomeModel {
    private String baseurl = "http://www.quanmin.tv/";
    public TVHomeModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }
    @Override
    public void getDataFirst(final MyCallBack callBack) {
        deploy(getApi().getTVShowList(), new ICallback<TVHomeBean>() {

            @Override
            public void onCompleted(TVHomeBean tvHomeBean) {
                callBack.success(tvHomeBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }
}
