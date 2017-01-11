package com.hoarse.library.imageloader.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hoarse.library.imageloader.ImageLoader;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public  class GlideImageLoader implements ImageLoader{

    @Override
    public void display(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @Override
    public void display(int resid, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(resid)
                .into(imageView);
    }
}
