package com.hoarse.library.net;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * 1.类的用途:OKHtttp拦截器管理类
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public  class InterceptorManager {
    private static List<Interceptor> sList=new ArrayList<>();
    public static void add(Interceptor interceptor){
        sList.add(interceptor);
    }
    public static List<Interceptor> getInterceptorList(){
        return sList;
    }
}
