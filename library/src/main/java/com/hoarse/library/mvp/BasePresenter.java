package com.hoarse.library.mvp;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> implements IBasePresenter {
    /*private IBaseView mBaseView;
    private IBaseModel mIBaseModel;*/
    private V mView;

    private M mModel;
    public BasePresenter(V v) {
        mView = v;
        mModel = createModel();
    }
    protected abstract M createModel();
    @Override
    public void attchView(IBaseView view) {
       // mBaseView = view;
    }

    @Override
    public void onStart() {
        //mIBaseModel = setModel();
    }

    @Override
    public void onDestroy() {
        if(mModel!=null)
            mModel.onDestroy();
        mModel=null;
    }

    /*public <T extends IBaseView> T getView() {
        return (T) mBaseView;
    }*/
    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }

}
