package com.hoarse.library.mvp;

/**
 * Created by gaojian on 2016/12/28.
 */

public interface IBasePresenter {
    void attchView(IBaseView view);

    void onStart();

    void onDestroy();
}
