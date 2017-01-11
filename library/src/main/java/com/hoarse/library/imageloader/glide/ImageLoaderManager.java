package com.hoarse.library.imageloader.glide;

import com.hoarse.library.imageloader.ImageLoader;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public class ImageLoaderManager {
    private static ImageLoaderManager mImageLoaderManager;
    public ImageLoaderManager() {
    }

    public static ImageLoaderManager getInstance() {
        if (mImageLoaderManager == null) {
            synchronized (ImageLoaderManager.class) {//保证了同一时间只能有一个对象访问此同步块
                if (mImageLoaderManager == null) {
                    mImageLoaderManager = new ImageLoaderManager();
                }
            }
        }
        return mImageLoaderManager;
    }

    public ImageLoader getImageLoader(Type type) {
        if (type == Type.GLIDE) {
            return new GlideImageLoader();
        }
        return new GlideImageLoader();
    }
    public enum Type {
        GLIDE;
    }

}

