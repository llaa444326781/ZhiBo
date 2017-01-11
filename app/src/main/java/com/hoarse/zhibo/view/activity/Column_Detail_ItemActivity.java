package com.hoarse.zhibo.view.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoarse.library.imageloader.glide.ImageLoaderManager;
import com.hoarse.library.mvp.BaseMvpActicity;
import com.hoarse.library.mvp.IBaseView;
import com.hoarse.zhibo.R;
import com.hoarse.zhibo.bean.ColumnDetail_itemBean;
import com.hoarse.zhibo.contract.Contract;
import com.hoarse.zhibo.presenter.ColumnDetailItemPresenter;

import butterknife.Bind;

public class Column_Detail_ItemActivity extends BaseMvpActicity<ColumnDetailItemPresenter> implements Contract.IColumnDetailItemActivity {
    @Bind(R.id.detail_bar_image)
    ImageView detailBarImage;
    @Bind(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.wv_detail_content)
    WebView wvDetailContent;
    @Bind(R.id.nsv_scroller)
    NestedScrollView nsvScroller;

    @Override
    public int getLayout() {
        return R.layout.activity_column__detail__item;
    }

    @Override
    public void getData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);
        getPresenter().getDataFirst(id);
    }

    @Override
    protected ColumnDetailItemPresenter createPresenter(IBaseView view) {
        return new ColumnDetailItemPresenter(this);
    }

    @Override
    public void getSuccess(ColumnDetail_itemBean columnDetail_itemBean) {
        ImageLoaderManager.getInstance()
                .getImageLoader(ImageLoaderManager.Type.GLIDE)
                .display(columnDetail_itemBean.image,detailBarImage);
        //detailBarCopyright.setText(columnDetail_itemBean.title);
        setToolbar(toolbar,columnDetail_itemBean.title);
        wvDetailContent.setWebChromeClient(new WebChromeClient());
        wvDetailContent.getSettings().setJavaScriptEnabled(true);
        wvDetailContent.loadUrl(columnDetail_itemBean.share_url);
    }
}
