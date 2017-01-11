package com.hoarse.zhibo.model;

import com.hoarse.library.log.MyLog;
import com.hoarse.library.mvp.BaseModel;
import com.hoarse.library.net.ICallback;
import com.hoarse.library.net.RetrofitHelper;
import com.hoarse.zhibo.IApi.IApi;
import com.hoarse.zhibo.bean.WechatBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public class WeChatModel extends BaseModel<IApi> implements IWeChatModel {
    private String baseurl = "http://api.tianapi.com/";
    int page = 1;

    public WeChatModel() {
        if (getApi() == null) {
            IApi api = RetrofitHelper.getService(baseurl, IApi.class);
            setApi(api);
        }
    }

    @Override
    public void getDataFirst(final MyCallBack<WechatBean> callBack) {
        deploy(getApi().getWeChat("09691a96d0c41d30215a888632e1b96e", 20, page), new ICallback<WechatBean>() {

            @Override
            public void onCompleted(WechatBean wechatBean) {
                callBack.success(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }

    @Override
    public void loadMore(final MyCallBack<WechatBean> callBack) {
        page++;
        deploy(getApi().getWeChat("09691a96d0c41d30215a888632e1b96e", 20, page), new ICallback<WechatBean>() {

            @Override
            public void onCompleted(WechatBean wechatBean) {
                callBack.success(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }

    @Override
    public void refresh(final MyCallBack<WechatBean> callBack) {
        page = 1;
        deploy(getApi().getWeChat("09691a96d0c41d30215a888632e1b96e", 20, page), new ICallback<WechatBean>() {

            @Override
            public void onCompleted(WechatBean wechatBean) {
                callBack.success(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                new MyLog().e(errMsg);
            }
        });
    }
}
