package com.hoarse.library.net;

import com.google.gson.Gson;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2016/7/11 17:15
 */
public class BaseResBean {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
