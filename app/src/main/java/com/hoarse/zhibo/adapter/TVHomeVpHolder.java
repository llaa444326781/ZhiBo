package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.view.View;

import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.TVHomeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述 ：
 * 创键人 :liuxiaoyu
 * 创建时间 :2017/1/3
 */

public class TVHomeVpHolder extends BaseViewHolder<TVHomeBean.RoomBean> {
    private ArrayList<String> titlelist;
    private ArrayList<String> imglist;
    List<TVHomeBean.RoomBean.ListBean> top_databean;
    private final Banner banner;

    public TVHomeVpHolder(View itemView) {
        super(itemView);
        banner = (Banner) itemView.findViewById(R.id.banner_daily);
    }

    @Override
    public void setData(Context context, TVHomeBean.RoomBean roomBean) {
        imglist = new ArrayList<String>();
        titlelist = new ArrayList<String>();
        List<TVHomeBean.RoomBean.ListBean> list = roomBean.list;
        for (int i = 0; i < list.size(); i++) {
            imglist.add(list.get(i).love_cover);
            titlelist.add(list.get(i).title);
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerTitles(titlelist);
        banner.setBannerAnimation(Transformer.ForegroundToBackground);
        banner.setImages(imglist)
                .setImageLoader(new com.hoarse.library.utils.glideutils.GlideImageLoader())
                .start();
    }
}