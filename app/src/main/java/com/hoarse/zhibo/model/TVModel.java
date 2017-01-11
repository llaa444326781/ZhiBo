package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.TVTitleBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/6.
 */

public class TVModel extends BaseModel<IApi> implements ITVModel {
    private String baseurl = "http://www.quanmin.tv/";
    public TVModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }

    @Override
    public void getDataFirst(final MyCallBack<List<TVTitleBean>> callBack) {
        deploy1(getApi().getTitleList(), new ICallback<List<TVTitleBean>>() {

            @Override
            public void onCompleted(List<TVTitleBean> tvTitleBean) {
                callBack.success(tvTitleBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }
}
