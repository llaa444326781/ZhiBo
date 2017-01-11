package com.hoarse.zhibo.model;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/30.
 */

public interface IBaseModel {
    void getDataFirst(MyCallBack myCallBack);
    void onDestroy();
}
