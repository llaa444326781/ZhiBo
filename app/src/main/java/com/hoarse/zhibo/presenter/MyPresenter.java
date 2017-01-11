package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.MyModel;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/30.
 */

public class MyPresenter extends BasePresenter<MyModel,Contract.IBaseMvpActivity> implements Contract.IBasePresenter {


    public MyPresenter(Contract.IBaseMvpActivity iBaseMvpActivity) {
        super(iBaseMvpActivity);
    }

    @Override
    protected MyModel createModel() {
        return new MyModel();
    }

    @Override
    public void getDataFirst() {
       /* getModel().getDataFirst(new MyCallBack() {
            @Override
            public void success(List<HomeBean.DataBean> list) {
                getView().getDataFirstSuccess(list);
            }

            @Override
            public void failed(String errMsg) {
                getView().getDataFirstFailed();
            }
        });*/
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void refresh() {

    }
}
