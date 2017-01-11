package com.hoarse.zhibo.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hoarse.library.mvp.BaseMvpFragment;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.adapter.TVHomeAdapter;
import com.hoarse.zhibo.bean.TVHomeBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.TVHomePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVHomeFragment extends BaseMvpFragment<TVHomePresenter> implements Contract.ITVHomeFrangment {
    RecyclerView mRecyclerView;

    @Override
    protected TVHomePresenter createPresenter(IBaseView view) {
        return new TVHomePresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_tvhome;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mRecyclerView = findView(R.id.rv_tvhome);
    }

    @Override
    public void loadData() {
        getPresenter().getDataFirst();
    }

    @Override
    public void getSuccess(TVHomeBean tvHomeBean) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new TVHomeAdapter(tvHomeBean.room, getActivity()));
    }
}
