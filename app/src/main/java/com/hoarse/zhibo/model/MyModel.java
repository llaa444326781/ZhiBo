package com.hoarse.zhibo.model;

import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.DailyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/30.
 */

public class MyModel extends BaseModel<IApi> implements IBaseModel {
    private List<DailyBean.StoriesBean> dataBeanList;

    @Override
    public void getDataFirst(final MyCallBack myCallBack) {
        dataBeanList = new ArrayList<>();
        deploy(getApi().getNewsData(), new ICallback<DailyBean>() {
            @Override
            public void onCompleted(DailyBean dailyBean) {
                myCallBack.success(dailyBean);
            }

            @Override
            public void onFailed(String errMsg) {
                System.out.println("");
            }
        });
    }
}
