package com.hoarse.library.imageloader;

import android.widget.ImageView;

/**
 * 1.类的用途:图片加载接口
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public interface ImageLoader {
    void display(String url, ImageView imageView);
    void display(int resid, ImageView imageView);
}
