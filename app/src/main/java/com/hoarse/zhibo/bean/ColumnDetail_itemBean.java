package com.hoarse.zhibo.bean;

import com.hoarse.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/5.
 */

public class ColumnDetail_itemBean extends ResponseBean {

    /**
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     * ga_prefix : 053122
     * id : 8358164
     * image : http://pic4.zhimg.com/aeef6b117532fc93872e2cb2fd6e0acf.jpg
     * image_source : 《月升王国》
     * images : ["http://pic1.zhimg.com/dafb3b8dd2a552f9107097377cb75a44.jpg"]
     * js : []
     * section : {"id":1,"name":"深夜惊奇","thumbnail":"http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg"}
     * share_url : http://daily.zhihu.com/story/8358164
     * title : 深夜惊奇 · 童年夏日记忆
     * type : 0
     */

    public String ga_prefix;
    public int id;
    public String image;
    public String image_source;
    public SectionBean section;
    public String share_url;
    public String title;
    public int type;
    public List<String> css;
    public List<String> images;
    public List<?> js;

    public static class SectionBean {
        /**
         * id : 1
         * name : 深夜惊奇
         * thumbnail : http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg
         */

        public int id;
        public String name;
        public String thumbnail;
    }
}
