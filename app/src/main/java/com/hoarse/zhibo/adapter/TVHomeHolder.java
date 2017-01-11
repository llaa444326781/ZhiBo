package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.TVHomeBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.raphets.roundimageview.RoundImageView;

import java.util.List;

/**
 * 类描述 ：
 * 创键人 :liuxiaoyu
 * 创建时间 :2017/1/3
 */
class TVHomeHolder extends BaseViewHolder<TVHomeBean.RoomBean> {
    RecyclerView mRecycler;
    TextView tv;
    List<TVHomeBean.RoomBean> stories;

    public TVHomeHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.category_name);
        mRecycler = (RecyclerView) itemView.findViewById(R.id.foot_recycler);
    }

    @Override
    public void setData(final Context context, final TVHomeBean.RoomBean roombean) {
        tv.setText(roombean.name);
        mRecycler.setLayoutManager(new GridLayoutManager(context, 2));
        CommonAdapter<TVHomeBean.RoomBean.ListBean> commonAdapter = new CommonAdapter<TVHomeBean.RoomBean.ListBean>(context, R.layout.zb_item, roombean.list) {
            @Override
            protected void convert(ViewHolder holder, TVHomeBean.RoomBean.ListBean roomBean, int position) {
                holder.setText(R.id.zb_nick, roomBean.nick);
                holder.setText(R.id.zb_title, roomBean.title);
                ImageView view = holder.getView(R.id.zb_large_image);
                RoundImageView roundImageView = holder.getView(R.id.zb_round_image);
                ImageLoaderManager.getInstance().getImageLoader(ImageLoaderManager.Type.GLIDE).display(roomBean.thumb, view);
                ImageLoaderManager.getInstance().getImageLoader(ImageLoaderManager.Type.GLIDE).display(roomBean.avatar, roundImageView);
            }
        };
        mRecycler.setAdapter(commonAdapter);
    }
}
