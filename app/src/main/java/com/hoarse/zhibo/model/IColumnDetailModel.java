package com.hoarse.zhibo.model;

import com.hoarse.zhibo.bean.ColumnDetailBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public interface IColumnDetailModel  {
    void getDataFirst( int id,MyCallBack<ColumnDetailBean> myCallBack);
}
