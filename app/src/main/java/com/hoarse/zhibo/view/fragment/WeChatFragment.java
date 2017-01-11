package com.hoarse.zhibo.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.library.mvp.BaseMvpFragment;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.WechatBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.WeChatPresenter;
import com.hoarse.zhibo.view.activity.WeChat_DetailActivity;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends BaseMvpFragment<WeChatPresenter> implements Contract.IWeChatFragment {

    @Bind(R.id.pullLoadMoreRecyclerView)
    PullLoadMoreRecyclerView pullLoadMoreRecyclerView;

    public WeChatFragment() {
    }


    @Override
    protected WeChatPresenter createPresenter(IBaseView view) {
        return new WeChatPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_we_chat;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
    }

    @Override
    public void loadData() {
        getPresenter().getDataFirst();
    }

    @Override
    public void getSuccess(final WechatBean wechatBean) {
        pullLoadMoreRecyclerView.setLinearLayout();
        CommonAdapter<WechatBean.NewslistBean> adapter = new CommonAdapter<WechatBean.NewslistBean>(getActivity(), R.layout.wechat_item, wechatBean.newslist) {
            @Override
            protected void convert(ViewHolder holder, WechatBean.NewslistBean newslistBean, int position) {
                holder.setText(R.id.tv_wechat_item_title, newslistBean.title);
                holder.setText(R.id.tv_wechat_item_from, newslistBean.description);
                holder.setText(R.id.tv_wechat_item_time, newslistBean.ctime);
                ImageView view = holder.getView(R.id.iv_wechat_item_image);
                ImageLoaderManager.getInstance()
                        .getImageLoader(ImageLoaderManager.Type.GLIDE)
                        .display(newslistBean.picUrl, view);
            }
        };
        pullLoadMoreRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent in=new Intent(getActivity(), WeChat_DetailActivity.class);
                in.putExtra("url",wechatBean.newslist.get(position).url);
                in.putExtra("title",wechatBean.newslist.get(position).title);
                startActivity(in);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                getPresenter().refresh();
                pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                getPresenter().loadMore();
                pullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
