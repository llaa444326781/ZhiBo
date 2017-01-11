package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.view.activity.Column_Detail_ItemActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述 ：
 * 创键人 :liuxiaoyu
 * 创建时间 :2017/1/3
 */

public class NewsVpHolder extends BaseViewHolder<DailyBean> {
    private ArrayList<String> titlelist;
    private ArrayList<String> imglist;
    List<DailyBean.TopStoriesBean> top_databean;
    private final Banner banner;

    public NewsVpHolder(View itemView) {
        super(itemView);
        banner = (Banner) itemView.findViewById(R.id.banner_daily);
    }

    @Override
    public void setData(final Context context, final DailyBean dailyBean) {
        imglist = new ArrayList<String>();
        titlelist = new ArrayList<String>();
        for (int i = 0; i < dailyBean.top_stories.size(); i++) {
            imglist.add(dailyBean.top_stories.get(i).image);
            titlelist.add(dailyBean.top_stories.get(i).title);
        }

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerTitles(titlelist);
        banner.setBannerAnimation(Transformer.ForegroundToBackground);
        banner.setImages(imglist)
                .setImageLoader(new com.hoarse.library.utils.glideutils.GlideImageLoader())
                .start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent in=new Intent(context,Column_Detail_ItemActivity.class);
                in.putExtra("id",dailyBean.top_stories.get(position-1).id);
                context.startActivity(in);
            }
        });

    }


}