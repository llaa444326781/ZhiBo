package com.hoarse.library.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoarse.library.mvp.IOnCreate;

import butterknife.ButterKnife;

/**
 * 1.类的用途:所有Fragment的基类
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public abstract class BaseFragment extends Fragment implements IOnCreate {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (bindLayout() != 0) {
            mView = View.inflate(getActivity(), bindLayout(), null);
            ButterKnife.bind(this, mView);
            initViews(savedInstanceState);
            initVariables();
            loadData();
        }
        return mView;

    }

    public void startAct(Class<? extends BaseActivity> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    public void startAct(Class<? extends BaseActivity> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public View getView() {
        return mView;
    }

    /**
     * 重构findViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T findView(int viewId) {
        if (mView != null) {
            return (T) mView.findViewById(viewId);
        }
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }


}
