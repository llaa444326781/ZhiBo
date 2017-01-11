package com.hoarse.zhibo.model;

import com.hoarse.zhibo.bean.ColumnBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public interface IColumnModel {
    void getDataFirst(MyCallBack<ColumnBean> myCallBack);
}
