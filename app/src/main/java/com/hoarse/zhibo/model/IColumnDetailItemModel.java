package com.hoarse.zhibo.model;

import com.hoarse.zhibo.bean.ColumnDetail_itemBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/5.
 */

public interface IColumnDetailItemModel {
    void getDataFirst( int id,MyCallBack<ColumnDetail_itemBean> myCallBack);
}
