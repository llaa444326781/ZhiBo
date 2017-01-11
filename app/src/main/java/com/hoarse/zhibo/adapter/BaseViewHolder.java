package com.hoarse.zhibo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 类描述 ：
 * 创键人 :liuxiaoyu
 * 创建时间 :2017/1/3
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(Context context, T t);
}