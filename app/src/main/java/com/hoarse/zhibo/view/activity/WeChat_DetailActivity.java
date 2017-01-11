package com.hoarse.zhibo.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.hoarse.library.base.BaseActivity;
import com.hoarse.zhibo.R;

public class WeChat_DetailActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    public int getLayout() {
        return R.layout.activity_we_chat__detail;
    }

    @Override
    public void initUI() {
        mWebView = findView(R.id.wechat_detail_webview);
        Toolbar mToolbar=findView(R.id.toolbar);
        Intent in=getIntent();
        String url=in.getStringExtra("url");
        String title=in.getStringExtra("title");
        setToolbar(mToolbar,title);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
    }

    @Override
    public void getData() {

    }
}
