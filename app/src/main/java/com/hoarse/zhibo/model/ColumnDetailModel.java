package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.ColumnDetailBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public class ColumnDetailModel extends BaseModel<IApi> implements IColumnDetailModel {
    private String baseurl = "http://news-at.zhihu.com/api/4/";

    public ColumnDetailModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }

    @Override
    public void getDataFirst(int id,final MyCallBack<ColumnDetailBean> myCallBack) {
        deploy(getApi().getListData(id), new ICallback<ColumnDetailBean>() {

            @Override
            public void onCompleted(ColumnDetailBean columnDetailBean) {
                myCallBack.success(columnDetailBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }
}
