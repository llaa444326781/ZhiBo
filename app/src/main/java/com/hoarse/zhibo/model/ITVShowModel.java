package com.hoarse.zhibo.model;

import com.hoarse.zhibo.bean.TVShowBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/7.
 */

public interface ITVShowModel {
    void getDataFirst( String path,MyCallBack<TVShowBean> myCallBack);
}
