package com.hoarse.zhibo.bean;

import com.hoarse.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/4.
 */

public class ColumnDetailBean extends ResponseBean{

    /**
     * name : 放映机
     * stories : [{"date":"20170103","display_date":"1 月 3 日","id":9118595,"images":["http://pic1.zhimg.com/b089433691f7f2176c33d23aa721275c.jpg"],"title":"「我到这种年纪了，还没有说过爱过谁比海更深」"},{"date":"20170102","display_date":"1 月 2 日","id":9114033,"images":["http://pic1.zhimg.com/457804ffeb418f808eecf026f730ab70.jpg"],"title":"我明确地告诉你，这故事里没有「好人」"},{"date":"20170101","display_date":"1 月 1 日","id":9114120,"images":["http://pic3.zhimg.com/b1d751d16970a1f7c0b919d4aeb2e1c6.jpg"],"title":"这部男女通吃的西班牙神剧，才是谍战剧的正确打开方式"},{"date":"20161231","display_date":"12 月 31 日","id":9111167,"images":["http://pic4.zhimg.com/9966d7be676634564901a0f18f83feb7.jpg"],"title":"今年还有这些有趣的作品，你可能错过了"},{"date":"20161230","display_date":"12 月 30 日","id":9107024,"images":["http://pic3.zhimg.com/f5e1030ee24f1793ac1b8db7c96a4cde.jpg"],"title":"无论你是 single 还是 couple，都能看到你想要的"},{"date":"20161229","display_date":"12 月 29 日","id":9106714,"images":["http://pic1.zhimg.com/b8c10db5ce0fd26ae1e534c87e439414.jpg"],"title":"父子关系可能是世界上最难剥的洋葱"},{"date":"20161228","display_date":"12 月 28 日","id":9103638,"images":["http://pic1.zhimg.com/5bd9eabd8c53e171798fee13d42673fc.jpg"],"title":"春节将至，我也想要个这样的形婚对象"},{"date":"20161227","display_date":"12 月 27 日","id":9100895,"images":["http://pic4.zhimg.com/84e781a9da04f0f24ee0f510eb40a533.jpg"],"title":"在遍布虚伪的地方，如何诚实地活着？"},{"date":"20161226","display_date":"12 月 26 日","id":9097728,"images":["http://pic3.zhimg.com/fafff8d996f5c7ae77b84a5787703332.jpg"],"title":"《现代启示录》这部电影的经典之处体现在哪里？"},{"date":"20161225","display_date":"12 月 25 日","id":9092143,"images":["http://pic4.zhimg.com/141c619fb2099bb0b1ccff98748402ab.jpg"],"title":"面对自己的恐惧，不要逃避"},{"date":"20161224","display_date":"12 月 24 日","id":9092720,"images":["http://pic4.zhimg.com/9286b6aad787936b2a0a673c31c00007.jpg"],"title":"一句话总结这部片：神改编，超出小说无数倍"},{"date":"20161223","display_date":"12 月 23 日","id":9090193,"images":["http://pic3.zhimg.com/011392e4aeb80bd7a3c7237a29963eba.jpg"],"title":"《天国王朝》这部电影中，哪些情节是虚构的？"},{"date":"20161222","display_date":"12 月 22 日","id":9087205,"images":["http://pic2.zhimg.com/e6e4df0befbd66b1794dc6e2fc5daba1.jpg"],"title":"一个老妓和她最后的欲拒还迎"},{"date":"20161221","display_date":"12 月 21 日","id":9083764,"images":["http://pic3.zhimg.com/55922e55ec3d7e631934fd7664c84c6e.jpg"],"title":"就喜欢《南方公园》这种脏话连篇，骨子里却三观极正的片"},{"date":"20161220","display_date":"12 月 20 日","id":9081356,"images":["http://pic2.zhimg.com/3aa829848d78065339992a97a25e4889.jpg"],"title":"醒醒吧，一段经历改变一个人的桥段只会在电影里发生"},{"date":"20161219","display_date":"12 月 19 日","id":9078752,"images":["http://pic1.zhimg.com/be68c8706d8e83a1273cf85b5da29420.jpg"],"title":"这是一部超牛的政治历史神剧"},{"date":"20161218","display_date":"12 月 18 日","id":9074494,"images":["http://pic2.zhimg.com/41da871805b03e2be57e839b1adc8509.jpg"],"title":"和战争的轰炸相比，更浓稠的阴影其实是\u2026\u2026"},{"date":"20161217","display_date":"12 月 17 日","id":9072735,"images":["http://pic3.zhimg.com/e744ae3eefe3570b71bb0a1907687042.jpg"],"title":"完成一场充满仪式感的事故需要多久？七天"},{"date":"20161216","display_date":"12 月 16 日","id":9071426,"images":["http://pic3.zhimg.com/7a484a1ccc16efe6abd57142d1841a4a.jpg"],"title":"不用特效，不用化妆，你也能感受到魔鬼的可怕"},{"date":"20161214","display_date":"12 月 14 日","id":9051654,"images":["http://pic1.zhimg.com/ee711f3c6f50ad1b644ec34dee3ad260.jpg"],"title":"看了这部片才知道，原来编写一部辞典这么麻烦"}]
     * timestamp : 1481720400
     */

    public String name;
    public int timestamp;
    public List<StoriesBean> stories;

    public static class StoriesBean {
        /**
         * date : 20170103
         * display_date : 1 月 3 日
         * id : 9118595
         * images : ["http://pic1.zhimg.com/b089433691f7f2176c33d23aa721275c.jpg"]
         * title : 「我到这种年纪了，还没有说过爱过谁比海更深」
         */

        public String date;
        public String display_date;
        public int id;
        public String title;
        public List<String> images;
    }
}
