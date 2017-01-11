package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.ColumnDetail_itemBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public class ColumnDetailItemModel extends BaseModel<IApi> implements IColumnDetailItemModel {
    private String baseurl = "http://news-at.zhihu.com/api/4/";

    public ColumnDetailItemModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }

    @Override
    public void getDataFirst(int id,final MyCallBack<ColumnDetail_itemBean> myCallBack) {
       deploy(getApi().getDetaShow(id), new ICallback<ColumnDetail_itemBean>() {

           @Override
           public void onCompleted(ColumnDetail_itemBean columnDetail_itemBean) {
               myCallBack.success(columnDetail_itemBean);
           }

           @Override
           public void onFailed(String errMsg) {
               new MyLog().e(errMsg);
           }
       });

    }
}
