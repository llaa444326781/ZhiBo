package com.hoarse.zhibo.view.activity;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hoarse.library.mvp.BaseMvpActicity;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.adapter.VpAdapter;
import com.hoarse.zhibo.bean.DailyBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.MyPresenter;
import com.hoarse.zhibo.view.fragment.ColumnFragment;
import com.hoarse.zhibo.view.fragment.DailyFragment;
import com.hoarse.zhibo.view.fragment.HotFragment;
import com.hoarse.zhibo.view.fragment.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

import static com.hoarse.zhibo.R.id.toolbar;

public class MainActivity extends BaseMvpActicity<MyPresenter> implements Contract.IBaseMvpActivity {
    private ActionBarDrawerToggle mMDrawerToggle;
    public static List<String> list_title;  //tab名称列表
    List<Fragment> fragments = new ArrayList<>(); //Fragment列表
    @Override
    protected MyPresenter createPresenter(IBaseView view) {
        return new MyPresenter(this);
    }
    @Override
    public void initUI() {
        super.initUI();
        setStatusColor(this,R.color.colorPrimary);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        Toolbar mToolbar = findView(toolbar);
        TabLayout mTabs = findView(R.id.tabs);
        AppBarLayout mAppBar = findView(R.id.appbarlayout);
        ViewPager mViewPager = findView(R.id.viewpager);
        NavigationView mNavView = findView(R.id.nav_view);
        DrawerLayout drawerLayout = findView(R.id.drawer_layout);
        // StatusBarUtil.setTransparent(this);
        mToolbar.setTitle("首页");
        mToolbar.setTitleTextColor(Color.WHITE);
        //mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("日报");
        list_title.add("专栏");
        list_title.add("微信");
        list_title.add("热门");
       /* //为TabLayout添加tab名称
        mTabs.addTab(mTabs.newTab().setText(list_title.get(0)));
        mTabs.addTab(mTabs.newTab().setText(list_title.get(1)));
        mTabs.addTab(mTabs.newTab().setText(list_title.get(2)));
        mTabs.addTab(mTabs.newTab().setText(list_title.get(3)));*/
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_tv:
                        startActivity(TVActivity.class);
                        break;
                }
                return true;
            }
        });
        mMDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mMDrawerToggle.syncState();//初始化状态
        drawerLayout.setDrawerListener(mMDrawerToggle);
        mToolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        mToolbar.inflateMenu(R.menu.fragment_main_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.day1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                        recreate();
                        break;
                    case R.id.night1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                        recreate();
                        break;
                }
                return true;
            }
        });
        fragments.add(new DailyFragment());
        fragments.add(new ColumnFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new HotFragment());
        mViewPager.setAdapter(new VpAdapter(getSupportFragmentManager(), fragments));
        mTabs.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dayofnightstyle, menu);
        return true;
    }

    @Override
    public int getLayout() {

        return R.layout.activity_main;
    }

    @Override
    public void getData() {

    }

    @Override
    public void getDataFirstSuccess(List<DailyBean.StoriesBean> list) {

    }

    @Override
    public void getDataFirstFailed() {

    }

}
