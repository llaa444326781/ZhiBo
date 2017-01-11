package com.hoarse.zhibo.bean;

import com.hoarse.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/6.
 */

public class TVHomeBean extends ResponseBean{

    public List<?> ad;
    public List<RoomBean> room;

    public static class RoomBean {
        /**
         * category_more :
         * icon :
         * id : 0
         * is_default : 1
         * list : [{"anniversary":0,"avatar":"http://image.quanmin.tv/avatar/64ee8584954c451d51d9a7e6ef29166ejpg?imageView2/2/w/300/","beauty_cover":"","category_id":29,"category_name":"颜值控","category_slug":"love","check":true,"coin":0,"create_at":"2017-01-06 13:03:08","default_image":"","fans":0,"first_play_at":"1970-01-01 08:00:00","follow":1385,"icontext":"颜值控","is_shield":false,"landscape":0,"last_end_at":"1970-01-01 08:00:00","last_play_at":"1970-01-01 08:00:00","last_thumb":"http://image.quanmin.tv/love/88d3152c3d84269e379359c40b74c6f9jpg?imageView2/2/w/500/","level":0,"like":0,"link":"http://www.quanmin.tv/v/8657138","love_cover":"http://image.quanmin.tv/love/88d3152c3d84269e379359c40b74c6f9jpg","max_view":0,"nick":"SuRa_","no":8657138,"play_count":0,"play_status":true,"play_true":0,"position":"","recommend_image":"","screen":1,"slug":"","starlight":0,"status":2,"stream":"","thumb":"http://image.quanmin.tv/love/88d3152c3d84269e379359c40b74c6f9jpg?imageView2/2/w/500/","title":"照骗、守护我吧","uid":8657138,"video":"http://thumb.quanmin.tv/8657138.mp4?t=1483682700","view":"5460","weight":0},{"anniversary":0,"avatar":"http://image.quanmin.tv/avatar/f03acb586f944149d2301300d2d16a58jpg?imageView2/2/w/300/","beauty_cover":"","category_id":5,"category_name":"单机主机","category_slug":"tvgame","check":true,"coin":0,"create_at":"2017-01-06 13:18:56","default_image":"","fans":0,"first_play_at":"1970-01-01 08:00:00","follow":1021,"icontext":"","is_shield":false,"landscape":1,"last_end_at":"1970-01-01 08:00:00","last_play_at":"1970-01-01 08:00:00","last_thumb":"2643962-1483545868-832.jpg","level":0,"like":0,"link":"http://www.quanmin.tv/v/2643962","love_cover":"","max_view":0,"nick":"CV季陌","no":2643962,"play_count":0,"play_status":true,"play_true":0,"position":"","recommend_image":"","screen":0,"slug":"","starlight":0,"status":2,"stream":"","thumb":"http://snap.quanmin.tv/2643962-1483610425-493.jpg?imageView2/2/w/390/","title":"『CV季陌』玩我喜欢的游戏做我喜欢的直播","uid":2643962,"video":"http://thumb.quanmin.tv/2643962.mp4?t=1483610400","view":"6719","weight":0},{"anniversary":0,"avatar":"http://image.quanmin.tv/avatar/3e4bfec6ee1bf22fe7b9c15a867beb8djpg?imageView2/2/w/300/","beauty_cover":"","category_id":3,"category_name":"炉石传说","category_slug":"heartstone","check":true,"coin":0,"create_at":"2017-01-06 10:09:24","default_image":"","fans":0,"first_play_at":"1970-01-01 08:00:00","follow":1637,"icontext":"","is_shield":false,"landscape":1,"last_end_at":"1970-01-01 08:00:00","last_play_at":"1970-01-01 08:00:00","last_thumb":"2138510-1483512927-524.jpg","level":0,"like":0,"link":"http://www.quanmin.tv/v/lengdiao","love_cover":"http://image.quanmin.tv/love/5bda32dfdb25cc94f3517017e624744bjpg","max_view":0,"nick":"冷掉","no":2138510,"play_count":0,"play_status":true,"play_true":0,"position":"","recommend_image":"","screen":0,"slug":"lengdiao","starlight":0,"status":2,"stream":"","thumb":"http://snap.quanmin.tv/2138510-1483682785-834.jpg?imageView2/2/w/390/","title":"天梯传说人数计算器","uid":2138510,"video":"http://thumb.quanmin.tv/2138510.mp4?t=1483682700","view":"18226","weight":0},{"anniversary":0,"avatar":"http://image.quanmin.tv/avatar/9fc5cc9839f1d8eb95ca6eacdc5c24ea?imageView2/2/w/300/","beauty_cover":"","category_id":13,"category_name":"全民户外","category_slug":"huwai","check":true,"coin":0,"create_at":"2017-01-06 11:49:01","default_image":"","fans":0,"first_play_at":"1970-01-01 08:00:00","follow":3965,"icontext":"","is_shield":false,"landscape":1,"last_end_at":"1970-01-01 08:00:00","last_play_at":"1970-01-01 08:00:00","last_thumb":"8962848-1483520462-737.jpg","level":0,"like":0,"link":"http://www.quanmin.tv/v/8962848","love_cover":"","max_view":0,"nick":"雷人张","no":8962848,"play_count":0,"play_status":true,"play_true":0,"position":"","recommend_image":"","screen":0,"slug":"","starlight":0,"status":2,"stream":"","thumb":"http://snap.quanmin.tv/8962848-1483682762-448.jpg?imageView2/2/w/390/","title":"荒山极限生存第三天。","uid":8962848,"video":"http://thumb.quanmin.tv/8962848.mp4?t=1483682700","view":"8300","weight":0},{"anniversary":0,"app_shuffling_image":"http://image.quanmin.tv/d6808580cd0c897366c76df33ed95902jpg","avatar":"http://image.quanmin.tv/avatar/ac45513f9123f49adc064f02f835f6f6?imageView2/2/w/300/","beauty_cover":"","category_id":1,"category_name":"英雄联盟","category_slug":"lol","check":true,"coin":0,"create_at":"2017-01-06 10:06:40","default_image":"","fans":0,"first_play_at":"1970-01-01 08:00:00","follow":547156,"icontext":"","is_shield":false,"landscape":1,"last_end_at":"1970-01-01 08:00:00","last_play_at":"1970-01-01 08:00:00","last_thumb":"333-1483517523-550.jpg","level":0,"like":0,"link":"http://www.quanmin.tv/v/333","love_cover":"","max_view":0,"nick":"孙悟空zzzz","no":333,"play_count":0,"play_status":true,"play_true":0,"position":"","recommend_image":"http://image.quanmin.tv/94c7901bce10d0636e704bba43a01045jpg","screen":0,"slug":"","starlight":0,"status":2,"stream":"","thumb":"http://snap.quanmin.tv/333-1483682784-945.jpg?imageView2/2/w/390/","title":"国服最强猴王","uid":333,"video":"http://thumb.quanmin.tv/333.mp4?t=1483682700","view":"313726","weight":0},{"anniversary":0,"app_shuffling_image":"http://image.quanmin.tv/a26090c88651ec45e5d11919ad9df0dajpg","avatar":"http://image.quanmin.tv/avatar/b718640cf2f4aa6560153cc6dff23ae3?imageView2/2/w/300/","beauty_cover":"","category_id":1,"category_name":"英雄联盟","category_slug":"lol","check":true,"coin":0,"create_at":"2017-01-06 13:20:51","default_image":"","fans":0,"first_play_at":"1970-01-01 08:00:00","follow":197592,"icontext":"","is_shield":false,"landscape":1,"last_end_at":"1970-01-01 08:00:00","last_play_at":"1970-01-01 08:00:00","last_thumb":"2064317-1483524243-940.jpg","level":0,"like":0,"link":"http://www.quanmin.tv/v/danrenying","love_cover":"","max_view":0,"nick":"全民丶单人影","no":2064317,"play_count":0,"play_status":true,"play_true":0,"position":"","recommend_image":"http://image.quanmin.tv/d9dcd6bab57ccb8aed12aec5461dfee6jpg","screen":0,"slug":"danrenying","starlight":0,"status":2,"stream":"","thumb":"http://snap.quanmin.tv/2064317-1483627022-34.jpg?imageView2/2/w/390/","title":"单人影：暴走火影劫","uid":2064317,"video":"http://thumb.quanmin.tv/2064317.mp4?t=1483626900","view":"247728","weight":0}]
         * name : 精彩推荐
         * screen : 0
         * slug :
         * type : 1
         */

        public String category_more;
        public String icon;
        public int id;
        public int is_default;
        public String name;
        public int screen;
        public String slug;
        public int type;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * anniversary : 0
             * avatar : http://image.quanmin.tv/avatar/64ee8584954c451d51d9a7e6ef29166ejpg?imageView2/2/w/300/
             * beauty_cover :
             * category_id : 29
             * category_name : 颜值控
             * category_slug : love
             * check : true
             * coin : 0
             * create_at : 2017-01-06 13:03:08
             * default_image :
             * fans : 0
             * first_play_at : 1970-01-01 08:00:00
             * follow : 1385
             * icontext : 颜值控
             * is_shield : false
             * landscape : 0
             * last_end_at : 1970-01-01 08:00:00
             * last_play_at : 1970-01-01 08:00:00
             * last_thumb : http://image.quanmin.tv/love/88d3152c3d84269e379359c40b74c6f9jpg?imageView2/2/w/500/
             * level : 0
             * like : 0
             * link : http://www.quanmin.tv/v/8657138
             * love_cover : http://image.quanmin.tv/love/88d3152c3d84269e379359c40b74c6f9jpg
             * max_view : 0
             * nick : SuRa_
             * no : 8657138
             * play_count : 0
             * play_status : true
             * play_true : 0
             * position :
             * recommend_image :
             * screen : 1
             * slug :
             * starlight : 0
             * status : 2
             * stream :
             * thumb : http://image.quanmin.tv/love/88d3152c3d84269e379359c40b74c6f9jpg?imageView2/2/w/500/
             * title : 照骗、守护我吧
             * uid : 8657138
             * video : http://thumb.quanmin.tv/8657138.mp4?t=1483682700
             * view : 5460
             * weight : 0
             * app_shuffling_image : http://image.quanmin.tv/d6808580cd0c897366c76df33ed95902jpg
             */

            public int anniversary;
            public String avatar;
            public String beauty_cover;
            public int category_id;
            public String category_name;
            public String category_slug;
            public boolean check;
            public int coin;
            public String create_at;
            public String default_image;
            public int fans;
            public String first_play_at;
            public int follow;
            public String icontext;
            public boolean is_shield;
            public int landscape;
            public String last_end_at;
            public String last_play_at;
            public String last_thumb;
            public int level;
            public int like;
            public String link;
            public String love_cover;
            public int max_view;
            public String nick;
            public int no;
            public int play_count;
            public boolean play_status;
            public int play_true;
            public String position;
            public String recommend_image;
            public int screen;
            public String slug;
            public int starlight;
            public int status;
            public String stream;
            public String thumb;
            public String title;
            public int uid;
            public String video;
            public String view;
            public int weight;
            public String app_shuffling_image;
        }
    }
}
