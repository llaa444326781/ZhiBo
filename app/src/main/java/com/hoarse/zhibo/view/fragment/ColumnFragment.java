package com.hoarse.zhibo.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.library.mvp.BaseMvpFragment;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.ColumnBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.ColumnPresenter;
import com.hoarse.zhibo.view.activity.Column_DetailActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColumnFragment extends BaseMvpFragment<ColumnPresenter> implements Contract.IColumnFragment {
    RecyclerView mRecyclerView;

    @Override
    public int bindLayout() {
        return R.layout.fragment_column;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mRecyclerView = findView(R.id.recyclerview_column);
    }

    @Override
    public void loadData() {
        getPresenter().getDataFirst();
    }

    @Override
    public void getSuccess(final ColumnBean columnBean) {

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        CommonAdapter<ColumnBean.DataBean> adapter = new CommonAdapter<ColumnBean.DataBean>(getActivity(), R.layout.column_item, columnBean.data) {
            @Override
            protected void convert(ViewHolder holder, ColumnBean.DataBean dataBean, int position) {
                holder.setText(R.id.column_tv, dataBean.name);
                ImageView view = holder.getView(R.id.column_img);
                ImageLoaderManager.getInstance()
                        .getImageLoader(ImageLoaderManager.Type.GLIDE)
                        .display(dataBean.thumbnail, view);
            }
        };
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent in=new Intent(getActivity(), Column_DetailActivity.class);
                in.putExtra("id",columnBean.data.get(position).id);
                in.putExtra("title",columnBean.data.get(position).name);
                startActivity(in);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @Override
    protected ColumnPresenter createPresenter(IBaseView view) {
        return new ColumnPresenter(this);
    }
}
