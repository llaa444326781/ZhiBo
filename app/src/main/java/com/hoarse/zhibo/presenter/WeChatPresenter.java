package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.WechatBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.MyCallBack;
import com.hoarse.zhibo.model.WeChatModel;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public class WeChatPresenter extends BasePresenter<WeChatModel,Contract.IWeChatFragment> implements Contract.IBasePresenter{
    public WeChatPresenter(Contract.IWeChatFragment iWeChatFragment) {
        super(iWeChatFragment);
    }

    @Override
    protected WeChatModel createModel() {
        return new WeChatModel();
    }

    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack<WechatBean>() {
            @Override
            public void success(WechatBean wechatBean) {
                getView().getSuccess(wechatBean);
            }

            @Override
            public void failed(String errorMsg) {

            }
        });
    }

    @Override
    public void loadMore() {
        getModel().loadMore(new MyCallBack<WechatBean>() {
            @Override
            public void success(WechatBean wechatBean) {
                getView().getSuccess(wechatBean);
            }

            @Override
            public void failed(String errorMsg) {

            }
        });
    }

    @Override
    public void refresh() {
        getModel().refresh(new MyCallBack<WechatBean>() {
            @Override
            public void success(WechatBean wechatBean) {
                getView().getSuccess(wechatBean);
            }

            @Override
            public void failed(String errorMsg) {

            }
        });
    }
}
