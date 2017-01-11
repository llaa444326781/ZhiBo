package com.hoarse.library.mvp;


import com.hoarse.library.base.BaseActivity;

/**
 * Created by liuxiaoyu on 2016/12/28.
 */

public abstract class BaseMvpActicity<P extends IBasePresenter> extends BaseActivity implements IBaseView{


    private P mPresenter;

    protected abstract P createPresenter(IBaseView view);
    @Override
    public void initUI() {

        mPresenter = createPresenter(this);
        if(mPresenter==null){
            throw new RuntimeException("presenter must be in createPresenter");
        }
    }

    @Override
    protected void onDestroy() {
        //避免Presenter持有该对象，先销毁Presenter
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        mPresenter=null;
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }
}
