package com.hoarse.zhibo.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.library.mvp.BaseMvpFragment;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.TVShowBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.TVShowPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.raphets.roundimageview.RoundImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends BaseMvpFragment<TVShowPresenter> implements Contract.ITVShowFrangment {

    @Bind(R.id.tvshow_rv)
    RecyclerView mRecyclerView;

    @Override
    protected TVShowPresenter createPresenter(IBaseView view) {
        return new TVShowPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_tvshow;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void loadData() {
        Bundle bundle=getArguments();
        String path=bundle.getString("path");
        getPresenter().getDataFirst(path);
    }

    @Override
    public void getSuccess(TVShowBean tvShowBean) {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.setAdapter(new CommonAdapter<TVShowBean.DataBean>(getActivity(),R.layout.zb_item,tvShowBean.data) {
            @Override
            protected void convert(ViewHolder holder, TVShowBean.DataBean dataBean, int position) {
                holder.setText(R.id.zb_nick, dataBean.nick);
                holder.setText(R.id.zb_title, dataBean.title);
                ImageView view = holder.getView(R.id.zb_large_image);
                RoundImageView roundImageView = holder.getView(R.id.zb_round_image);
                ImageLoaderManager.getInstance().getImageLoader(ImageLoaderManager.Type.GLIDE).display(dataBean.thumb, view);
                ImageLoaderManager.getInstance().getImageLoader(ImageLoaderManager.Type.GLIDE).display(dataBean.avatar, roundImageView);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
