package com.hoarse.library.log;

import com.socks.library.KLog;

/**
 * 1.类的用途:日志管理
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public class MyLog implements IMyLog {
    @Override
    public void v(Object obj) {
        KLog.v(obj);
    }

    @Override
    public void d(Object obj) {
        KLog.d(obj);
    }

    @Override
    public void i(Object obj) {
        KLog.i(obj);
    }

    @Override
    public void w(Object obj) {
        KLog.w(obj);
    }

    @Override
    public void e(Object obj) {
        KLog.e(obj);
    }

    @Override
    public void json(String json) {
        KLog.json(json);
    }
}
