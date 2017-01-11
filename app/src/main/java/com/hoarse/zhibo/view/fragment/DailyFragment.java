package com.hoarse.zhibo.view.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hoarse.library.mvp.BaseMvpFragment;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.adapter.DailyAdapter;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.DailyPresenter;

public class DailyFragment extends BaseMvpFragment<DailyPresenter> implements Contract.IDailyFragment {
    RecyclerView mRecyclerView;

    @Override
    public int bindLayout() {
        return R.layout.fragment_daily;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mRecyclerView = findView(R.id.recyclerview_daily);
    }

    @Override
    public void loadData() {
        getPresenter().getDataFirst();
    }


    @Override
    protected DailyPresenter createPresenter(IBaseView view) {
        return new DailyPresenter(this);
    }

    @Override
    public void getSuccess(DailyBean dailyBean) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new DailyAdapter(dailyBean, getActivity()));
    }
}
