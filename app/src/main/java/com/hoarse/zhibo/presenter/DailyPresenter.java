package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.DailyModel;
import com.hoarse.zhibo.model.MyCallBack;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class DailyPresenter extends BasePresenter<DailyModel,Contract.IDailyFragment> implements Contract.IBasePresenter {
    public DailyPresenter(Contract.IDailyFragment iDailyFragment) {
        super(iDailyFragment);
    }

    @Override
    protected DailyModel createModel() {
        return new DailyModel();
    }

    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack<DailyBean>() {
            @Override
            public void success(DailyBean dailyBean) {
                getView().getSuccess(dailyBean);
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
