package com.hoarse.zhibo.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.library.mvp.BaseMvpActicity;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.ColumnDetailBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.ColumnDetailPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class Column_DetailActivity extends BaseMvpActicity<ColumnDetailPresenter> implements Contract.IColumnDetailActivity{
    RecyclerView mRecyclerView;
    Toolbar mToolbar;
    @Override
    protected ColumnDetailPresenter createPresenter(IBaseView view) {
        return new ColumnDetailPresenter(this);
    }

    @Override
    public void initUI() {
        super.initUI();
        mRecyclerView=findView(R.id.activity_column__detail_rv);
        mToolbar=findView(R.id.toolbar);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_column__detail;
    }

    @Override
    public void getData() {Intent intent=getIntent();
        int id=intent.getIntExtra("id",1);
        String title=intent.getStringExtra("title");
        setToolbar(mToolbar,title);
       getPresenter().getDataFirst(id);
    }

    @Override
    public void getSuccess(final ColumnDetailBean columnDetailBean) {


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommonAdapter<ColumnDetailBean.StoriesBean> adapter = new CommonAdapter<ColumnDetailBean.StoriesBean>(this, R.layout.ribao_item, columnDetailBean.stories) {
            @Override
            protected void convert(ViewHolder holder, ColumnDetailBean.StoriesBean storiesBean, int position) {
                holder.setText(R.id.ribao_item_tv, storiesBean.title);
                ImageView view = holder.getView(R.id.ribao_item_img);
                ImageLoaderManager.getInstance()
                        .getImageLoader(ImageLoaderManager.Type.GLIDE)
                        .display(storiesBean.images.get(0), view);
            }
        };
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent in=new Intent(Column_DetailActivity.this,Column_Detail_ItemActivity.class);
                in.putExtra("id",columnDetailBean.stories.get(position).id);
                startActivity(in);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }
}
