package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.ColumnDetailBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.ColumnDetailModel;
import com.hoarse.zhibo.model.MyCallBack;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class ColumnDetailPresenter extends BasePresenter<ColumnDetailModel,Contract.IColumnDetailActivity> implements Contract.IBasePresenter1{


    public ColumnDetailPresenter(Contract.IColumnDetailActivity iColumnDetailActivity) {
        super(iColumnDetailActivity);
    }

    @Override
    protected ColumnDetailModel createModel() {
        return new ColumnDetailModel();
    }
    @Override
    public void getDataFirst(int id) {
        getModel().getDataFirst(id,new MyCallBack<ColumnDetailBean>() {
            @Override
            public void success(ColumnDetailBean columnDetailBean) {
                getView().getSuccess(columnDetailBean);
            }

            @Override
            public void failed(String errorMsg) {

            }
        });
    }
}
