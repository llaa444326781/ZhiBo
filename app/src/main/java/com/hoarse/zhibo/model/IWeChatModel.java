package com.hoarse.zhibo.model;

import com.hoarse.zhibo.bean.WechatBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public interface IWeChatModel {
    void getDataFirst(MyCallBack<WechatBean> callBack);
    void loadMore(MyCallBack<WechatBean> callBack);
    void refresh(MyCallBack<WechatBean> callBack);
}
