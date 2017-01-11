package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.TVHomeBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.MyCallBack;
import com.hoarse.zhibo.model.TVHomeModel;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/6.
 */

public class TVHomePresenter extends BasePresenter<TVHomeModel, Contract.ITVHomeFrangment> implements Contract.IBasePresenter {
    public TVHomePresenter(Contract.ITVHomeFrangment itvHomeFrangment) {
        super(itvHomeFrangment);
    }

    @Override
    protected TVHomeModel createModel() {
        return new TVHomeModel();
    }

    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack<TVHomeBean>() {
            @Override
            public void success(TVHomeBean tvHomeBean) {
                getView().getSuccess(tvHomeBean);
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
