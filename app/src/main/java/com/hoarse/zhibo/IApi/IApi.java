package com.hoarse.zhibo.IApi;

import com.hoarse.zhibo.bean.ColumnDetailBean;
import com.hoarse.zhibo.bean.ColumnDetail_itemBean;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.bean.ColumnBean;
import com.hoarse.zhibo.bean.TVHomeBean;
import com.hoarse.zhibo.bean.TVShowBean;
import com.hoarse.zhibo.bean.TVTitleBean;
import com.hoarse.zhibo.bean.WechatBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/30.
 */

public interface IApi {
    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<DailyBean> getNewsData();

    /**
     * 专栏日报
     */
    @GET("sections")
    Observable<ColumnBean> getSpecilData();

    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Observable<WechatBean> getWeChat(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    /**
     * 专栏日报详情
     */
    @GET("section/{id}")
    Observable<ColumnDetailBean> getListData(@Path("id") int id);

    /**
     * 专栏日报详情item
     */
    @GET("news/{id}")
    Observable<ColumnDetail_itemBean> getDetaShow(@Path("id") int id);

    /**
     * 全民TV TabLayout
     */
    @GET("json/app/index/category/info-android.json?v=2.2.4&os=1&ver=4")
    Observable<List<TVTitleBean>> getTitleList();

    /**
     * 全民TV Home
     */
    @GET("json/app/index/recommend/list-android.json?11241742&v=2.2.4&os=1&ver=4")
    Observable<TVHomeBean> getTVShowList();
    /**
     * 全民TV Show
     */
    @GET("json%2Fcategories%2{str}%2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4")
    Observable<TVShowBean> getTVShowData(@Path("str") String path);
}
