package com.hoarse.zhibo.presenter;

import com.hoarse.library.mvp.BasePresenter;
import com.hoarse.zhibo.bean.TVShowBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.model.MyCallBack;
import com.hoarse.zhibo.model.TVShowModel;

/**
 * 1.类的用途
 * 2.@ author:Liuxiaoyu
 * 3.@ 2017/1/7.
 */

public class TVShowPresenter extends BasePresenter<TVShowModel,Contract.ITVShowFrangment> implements Contract.IBasePresenter2 {
    public TVShowPresenter(Contract.ITVShowFrangment itvShowFrangment) {
        super(itvShowFrangment);
    }

    @Override
    protected TVShowModel createModel() {
        return new TVShowModel();
    }

    @Override
    public void getDataFirst(String path) {
getModel().getDataFirst(path, new MyCallBack<TVShowBean>() {
    @Override
    public void success(TVShowBean tvShowBean) {
        getView().getSuccess(tvShowBean);
    }

    @Override
    public void failed(String errorMsg) {
System.out.println();
    }
});
    }
}
