package com.hoarse.library.mvp;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoarse.library.base.BaseFragment;

/**
 * Created by liuxiaoyu on 2016/12/28.
 */

public abstract class BaseMvpFragment<P extends IBasePresenter>  extends BaseFragment implements IBaseView {
    private P mPresenter;
    protected abstract P createPresenter(IBaseView view);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        mPresenter = createPresenter(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
     /*@Override
   public void initViews(Bundle savedInstanceState) {
        mPresenter = createPresenter(this);
        mLoadingDialog = getLoadingDialog();
        if (mPresenter == null) {
            throw new RuntimeException("presenter muse be in createPresenter");
        }
    }*/

    public P getPresenter() {
        return mPresenter;
    }

    protected Dialog getLoadingDialog() {
        return new Dialog(getActivity());
    }
    @Override
    public void onDestroy() {

        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }
}
