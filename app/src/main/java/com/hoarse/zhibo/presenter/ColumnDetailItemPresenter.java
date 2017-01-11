package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.ColumnDetail_itemBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.ColumnDetailItemModel;
import com.hoarse.zhibo.model.MyCallBack;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class ColumnDetailItemPresenter extends BasePresenter<ColumnDetailItemModel,Contract.IColumnDetailItemActivity> implements Contract.IBasePresenter1{

    public ColumnDetailItemPresenter(Contract.IColumnDetailItemActivity iColumnDetailItemActivity) {
        super(iColumnDetailItemActivity);
    }

    @Override
    protected ColumnDetailItemModel createModel() {
        return new ColumnDetailItemModel();
    }
    @Override
    public void getDataFirst(int id) {
        getModel().getDataFirst(id,new MyCallBack<ColumnDetail_itemBean>() {
            @Override
            public void success(ColumnDetail_itemBean columnDetail_itemBean) {
                getView().getSuccess(columnDetail_itemBean);
            }

            @Override
            public void failed(String errorMsg) {

            }
        });
    }
}
