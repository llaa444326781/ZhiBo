package com.hoarse.library.base;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/29.
 */

public interface MyInterface {
    /**
     * 返回布局ID
     * @return
     */
    int getLayout();
    /**
     * 初始化控件
     */
    void initUI();
    /**
     * 初始化数据
     */
    void getData();
}
