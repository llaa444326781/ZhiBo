package com.hoarse.zhibo.bean;

import com.hoarse.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class DailyBean extends ResponseBean {

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public boolean multipic;
        public List<String> images;
    }
    public static class TopStoriesBean {
        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}
