package com.hoarse.zhibo.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.hoarse.library.mvp.BaseMvpActicity;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.adapter.TVVpAdapter;
import com.hoarse.zhibo.bean.TVTitleBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.TVPresenter;
import com.hoarse.zhibo.view.fragment.TVHomeFragment;
import com.hoarse.zhibo.view.fragment.TVShowFragment;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.hoarse.zhibo.R.id.tv_tabs;

public class TVActivity extends BaseMvpActicity<TVPresenter> implements Contract.ITVActivity {

    @Bind(R.id.tv_toolbar)
    Toolbar tvToolbar;
    @Bind(tv_tabs)
    TabLayout tvTabs;
    @Bind(R.id.tv_appbarlayout)
    AppBarLayout tvAppbarlayout;
    @Bind(R.id.tv_viewpager)
    ViewPager tvViewpager;
    public static List<TVTitleBean> mlist;
    List<Fragment> fragments = new ArrayList<>(); //Fragment列表
    String[] paths = {"Flol","Fbeauty","Foverwatch", "Fhuwai", "Fheartstone","Fmobilegame","Fwebgame","Ftvgame","Fwangzhe","F","Fdota2","Fcfpc","Fdnf","Fqqfeiche","Fwar34","Fnba2k","Fminecraft", "Ffifa","Fblizzard","Fqiuqiu","Ferciyuan","Fcfpc",
            "Fjianling",
            "Fqqfeiche",
            "Flimingshaji",
            "Fnba2k",
            "Fmsg",
            "Ffifa",
            "Ffs",
            "Fwar3",
            "Fzhuangjiafengbao",
            "Fwangzhe",
            "Fstreet"};

    @Override
    protected TVPresenter createPresenter(IBaseView view) {
        return new TVPresenter(this);
    }

    @Override
    public int getLayout() {
        setStatusColor(this,R.color.colorPrimary);
        return R.layout.activity_tv;
    }

    @Override
    public void getData() {
        getPresenter().getDataFirst();
    }

    @Override
    public void getSuccess(List<TVTitleBean> list) {
        mlist = list;
        tvToolbar.setTitle("全民TV");
        tvToolbar.setTitleTextColor(Color.WHITE);
        tvTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        /*for (TVTitleBean tvTitleBean : list) {
            tvTabs.addTab(tvTabs.newTab().setText(tvTitleBean.name));
        }*/
        fragments.add(new TVHomeFragment());
        for (int i = 0; i < paths.length; i++) {
            TVShowFragment tvShowFragment = new TVShowFragment();
            Bundle bundle = new Bundle();
            bundle.putString("path", paths[i]);
            tvShowFragment.setArguments(bundle);
            fragments.add(tvShowFragment);
        }
        tvViewpager.setAdapter(new TVVpAdapter(getSupportFragmentManager(), fragments));
        tvTabs.setupWithViewPager(tvViewpager);
    }
}
