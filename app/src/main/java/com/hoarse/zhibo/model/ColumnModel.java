package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.ColumnBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class ColumnModel extends BaseModel<IApi> implements IColumnModel{
    private String baseurl = "http://news-at.zhihu.com/api/4/";

    public ColumnModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }

    @Override
    public void getDataFirst(final MyCallBack myCallBack) {
        deploy(getApi().getSpecilData(), new ICallback<ColumnBean>() {

            @Override
            public void onCompleted(ColumnBean columnBean) {
                myCallBack.success(columnBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }
}
