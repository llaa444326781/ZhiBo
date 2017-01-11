package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.view.activity.Column_Detail_ItemActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * 类描述 ：
 * 创键人 :liuxiaoyu
 * 创建时间 :2017/1/3
 */
class DailyHolder extends BaseViewHolder<DailyBean> {
    RecyclerView mRecycler;
    List<DailyBean.StoriesBean> stories;

    public DailyHolder(View itemView) {
        super(itemView);
        mRecycler = (RecyclerView) itemView.findViewById(R.id.rv_daily);
    }

    @Override
    public void setData(final Context context, final DailyBean dailyBean) {
        stories = dailyBean.stories;
        mRecycler.setLayoutManager(new LinearLayoutManager(context));
        CommonAdapter<DailyBean.StoriesBean> commonAdapter = new CommonAdapter<DailyBean.StoriesBean>(context, R.layout.ribao_item, dailyBean.stories) {
            @Override
            protected void convert(ViewHolder holder, DailyBean.StoriesBean storiesBean, int position) {
                holder.setText(R.id.ribao_item_tv, storiesBean.title);
                ImageView view = holder.getView(R.id.ribao_item_img);
                ImageLoaderManager.getInstance()
                        .getImageLoader(ImageLoaderManager.Type.GLIDE)
                        .display(storiesBean.images.get(0), view);

            }
        };
        mRecycler.setAdapter(commonAdapter);
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent in=new Intent(context,Column_Detail_ItemActivity.class);
                in.putExtra("id",dailyBean.stories.get(position).id);
                context.startActivity(in);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });


    }
}
