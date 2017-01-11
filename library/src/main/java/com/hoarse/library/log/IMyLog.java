package com.hoarse.library.log;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public interface IMyLog {
    void v(Object obj);

    void d(Object obj);

    void i(Object obj);

    void w(Object obj);

    void e(Object obj);

    void json(String json);
}
