package com.hoarse.zhibo.contract;

import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.bean.ColumnDetailBean;
import com.hoarse.zhibo.bean.ColumnDetail_itemBean;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.bean.ColumnBean;
import com.hoarse.zhibo.bean.TVHomeBean;
import com.hoarse.zhibo.bean.TVShowBean;
import com.hoarse.zhibo.bean.TVTitleBean;
import com.hoarse.zhibo.bean.WechatBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/30.
 */

public class Contract {
    public interface IBasePresenter {
        void getDataFirst();
        void loadMore();
        void refresh();
        void onDestroy();
    }
    public interface IBasePresenter1 {
        void getDataFirst(int id);
    }
    public interface IBasePresenter2 {
        void getDataFirst(String path);
    }
    public interface IBaseMvpActivity extends IBaseView {
        void getDataFirstSuccess(List<DailyBean.StoriesBean> list);
        void getDataFirstFailed();
    }
    public interface IDailyFragment extends IBaseView {
        void getSuccess(DailyBean dailyBean);
    }
    public interface IColumnFragment extends IBaseView {
        void getSuccess(ColumnBean columnBean);
    }
    public interface IWeChatFragment extends IBaseView {
        void getSuccess(WechatBean wechatBean);
    }
    public interface IColumnDetailActivity extends IBaseView {
        void getSuccess(ColumnDetailBean columnDetailBean);
    }
    public interface IColumnDetailItemActivity extends IBaseView {
        void getSuccess(ColumnDetail_itemBean columnDetail_itemBean);
    }

    public interface ITVActivity extends IBaseView {
        void getSuccess(List<TVTitleBean> list);
    }

    public interface ITVHomeFrangment extends IBaseView {
        void getSuccess(TVHomeBean tvHomeBean);
    }
    public interface ITVShowFrangment extends IBaseView {
        void getSuccess(TVShowBean tvShowBean);
    }
}
