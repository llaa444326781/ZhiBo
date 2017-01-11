package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.TVHomeBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class TVHomeAdapter extends RecyclerView.Adapter<BaseViewHolder<TVHomeBean.RoomBean>> {

    private List<TVHomeBean.RoomBean> list;
    private Context mContext;
    public static final int TYPE0 = 0;
    public static final int TYPE1 = 1;

    public TVHomeAdapter(List<TVHomeBean.RoomBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public BaseViewHolder<TVHomeBean.RoomBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE0:
                return new TVHomeVpHolder(LayoutInflater.from(mContext).inflate(R.layout.daily_item_vp, parent, false));
            case TYPE1:
                return new TVHomeHolder(LayoutInflater.from(mContext).inflate(R.layout.yz_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<TVHomeBean.RoomBean> holder, int position) {
        holder.setData(mContext, list.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE0;
        } else {
            return TYPE1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
