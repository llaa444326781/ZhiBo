package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.TVTitleBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.MyCallBack;
import com.hoarse.zhibo.model.TVModel;

import java.util.List;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/6.
 */

public class TVPresenter extends BasePresenter<TVModel,Contract.ITVActivity> implements Contract.IBasePresenter {
    public TVPresenter(Contract.ITVActivity itvActivity) {
        super(itvActivity);
    }
    @Override
    protected TVModel createModel() {
        return new TVModel();
    }

    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack<List<TVTitleBean>>() {
            @Override
            public void success(List<TVTitleBean> tvTitleBean) {
                getView().getSuccess(tvTitleBean);
            }

            @Override
            public void failed(String errorMsg) {
System.out.println();
            }
        });
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void refresh() {

    }
}
