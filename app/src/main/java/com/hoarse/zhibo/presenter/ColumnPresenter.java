package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.ColumnBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.ColumnModel;
import com.hoarse.zhibo.model.MyCallBack;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/3.
 */

public class ColumnPresenter extends BasePresenter<ColumnModel,Contract.IColumnFragment> implements Contract.IBasePresenter{
    public ColumnPresenter(Contract.IColumnFragment iColumnFragment) {
        super(iColumnFragment);
    }

    @Override
    protected ColumnModel createModel() {
        return new ColumnModel();
    }

    @Override
    public void getDataFirst() {
        getModel().getDataFirst(new MyCallBack<ColumnBean>() {
            @Override
            public void success(ColumnBean columnBean) {
                getView().getSuccess(columnBean);
            }

            @Override
            public void failed(String errorMsg) {

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
