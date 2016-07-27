package com.kuahusg.v2exwithmvp.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kuahusg.v2exwithmvp.Model.News;
import com.kuahusg.v2exwithmvp.Presenter.NewsDetailPresenter;
import com.kuahusg.v2exwithmvp.R;

/**
 * Created by kuahusg on 16-7-26.
 */
public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter> implements INewsDetailView {
    ImageView imgIcon;
    TextView tvUserName;
    TextView tvNode;
    TextView tvTitle;
    WebView wvNewsDetail;
    Toolbar toolbar;
    ProgressBar progressBar;
    News news;

    public static void startActivity(Context context, News news) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("news", news);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initWebView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle("V2ex");
        getPresenter().loadWebView(wvNewsDetail, news.getUrl());
    }

    private void initView() {
        imgIcon = (ImageView) findViewById(R.id.img_user_icon);
        tvUserName = (TextView) findViewById(R.id.txt_username);
        tvNode = (TextView) findViewById(R.id.txt_node);
        wvNewsDetail = (WebView) findViewById(R.id.wv_news_detail);
        tvTitle = (TextView) findViewById(R.id.news_title);
        progressBar = (ProgressBar) findViewById(R.id.pb_loading_wv);
        toolbar = setToolbar("", -1);

        news = ((News) getIntent().getSerializableExtra("news"));

        Glide.with(this).load("http:" + news.getMember().getAvatar_normal()).fitCenter().into(imgIcon);
        tvNode.setText(news.getNode().getTitle());
        tvUserName.setText(news.getMember().getUsername());
        tvTitle.setText(news.getTitle());


    }

    private void initWebView() {
        wvNewsDetail.getSettings().setJavaScriptEnabled(false);
        wvNewsDetail.getSettings().setSupportZoom(false);
        wvNewsDetail.getSettings().setBuiltInZoomControls(false);
        wvNewsDetail.setDrawingCacheEnabled(true);
        wvNewsDetail.getSettings().setAppCacheEnabled(true);
        wvNewsDetail.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    public NewsDetailPresenter setPresenter() {
        return new NewsDetailPresenter(this);
    }

    @Override
    public void afterFinish() {
//        Toast.makeText(NewsDetailActivity.this, getString(R.string.load_finish), Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void err(String message) {
        Toast.makeText(NewsDetailActivity.this, message, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void init() {
        progressBar.setVisibility(View.VISIBLE);

    }
}
