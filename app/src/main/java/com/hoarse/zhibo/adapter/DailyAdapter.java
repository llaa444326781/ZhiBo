package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.DailyBean;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class DailyAdapter extends RecyclerView.Adapter<BaseViewHolder<DailyBean>>{
    private DailyBean mDailyBean;
    private Context mContext;
    public static final int TYPE0 = 0;
    public static final int TYPE1 = 1;

    public DailyAdapter(DailyBean dailyBean, Context context) {
        this.mDailyBean = dailyBean;
        mContext = context;
    }

    @Override
    public BaseViewHolder<DailyBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE0:
                return new NewsVpHolder(LayoutInflater.from(mContext).inflate(R.layout.daily_item_vp, parent, false));
            case TYPE1:
                return new DailyHolder(LayoutInflater.from(mContext).inflate(R.layout.daily_item_cardview, parent, false));
        }
        return null;
    }
    @Override
    public void onBindViewHolder(BaseViewHolder<DailyBean> holder, int position) {
        holder.setData(mContext, mDailyBean);
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
        return 2;
    }
}
