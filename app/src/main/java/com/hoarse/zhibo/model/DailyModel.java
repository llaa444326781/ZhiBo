package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.DailyBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class DailyModel extends BaseModel<IApi> implements IDailyModel {
    private String baseurl = "http://news-at.zhihu.com/api/4/";
    public DailyModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }

    @Override
    public void getDataFirst(final MyCallBack callBack) {
    deploy(getApi().getNewsData(), new ICallback<DailyBean>() {
        @Override
        public void onCompleted(DailyBean dailyBean) {
            callBack.success(dailyBean);
        }
        @Override
        public void onFailed(String errMsg) {
            new MyLog().e(errMsg);
        }
    });
    }
}
