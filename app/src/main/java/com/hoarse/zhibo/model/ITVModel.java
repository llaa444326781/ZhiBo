package com.hoarse.zhibo.model;

import com.hoarse.zhibo.bean.TVTitleBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/6.
 */

public interface ITVModel {
    void getDataFirst(MyCallBack<List<TVTitleBean>> callBack);
}
