package com.hoarse.library.utils.glideutils;

import android.content.Context;
import android.os.Looper;

import com.bumptech.glide.Glide;
/**1.DiskCache

 1.1、硬盘缓存是在一个后台线程当中，通过一个DiskCache.Factory接口进行缓存的。

 开发者能够通过GlideBuilder的setDiskCache(DiskCache.Factory df)方法设置存储的位置和大小

 通过传入DiskCacheAdapter来完全禁用缓存

 自定义一个DiskCache来完全禁用缓存，

 Glide默认是用InternalCacheDiskCacheFactory类来创建硬盘缓存的，
 这个类会在应用的内部缓存目录下面创建一个最大容量250MB的缓存文件夹，
 使用这个缓存目录而不用sd卡，意味着除了本应用之外，
 其他应用是不能访问缓存的图片文件的。
 可以通过实现DiskCache.Factory，然后使用DiskLruCacheWrapper
 创建一个新的缓存目录，比如，可以通过如下方式在外存当中创建缓存目录：

 builder .setDiskCache(new DiskCache.Factory() {
@Override
public DiskCache build() {
// Careful: the external cache directory doesn't enforce permissions
File cacheLocation = new File(context.getExternalCacheDir(), "cache_dir_name");
cacheLocation.mkdirs();
return DiskLruCacheWrapper.get(cacheLocation, yourSizeInBytes);
}
});
 *
 */
/**
 * 1：类的用途Glide
 * 2:@author:XueHao
 * 3:@ 2016/11/23.
 */

public class GlideUtil {
    private static GlideUtil inst;

    public static GlideUtil getInstance() {
        if (inst == null) {
            inst = new GlideUtil();
        }
        return inst;
    }

    /**
     * 取消所有正在下载或等待下载的任务。
     */
    public static void cancelAllTasks(Context context) {
        Glide.with(context).pauseRequests();
    }

    /**
     * 恢复所有任务
     */
    public static void resumeAllTasks(Context context) {
        Glide.with(context).resumeRequests();
    }

    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public static void clearDiskCache(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(context).clearDiskCache();
            }
        }).start();
    }

    /**
     * 清除所有缓存
     *
     * @param context
     */
    public static void cleanAll(Context context) {
        clearDiskCache(context);
        Glide.get(context).clearMemory();
    }

    
    /**
     * 清除图片内存缓存是hashmap中的内存清除掉
     */
    public void clearImageMemoryCache(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


 /*   *
     * 获取Glide造成的缓存大小
     *
     * @return CacheSize
    public String getCacheSize(Context context) {
        try {
            return getFormatSize(getFolderSize(new File(context.getCacheDir() + "/" + InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }*/
}
