package com.hoarse.zhibo.model;

/**
 * 1.类的用途
 * 2.@author:liwei
 * 3.@2016/12/29
 */

public interface MyCallBack<T> {
    void success(T t);
    void failed(String errorMsg);

}
