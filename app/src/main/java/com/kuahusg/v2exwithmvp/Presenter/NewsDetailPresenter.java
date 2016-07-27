package com.kuahusg.v2exwithmvp.Presenter;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kuahusg.v2exwithmvp.R;
import com.kuahusg.v2exwithmvp.View.Activity.NewsDetailActivity;

/**
 * Created by kuahusg on 16-7-26.
 */
public class NewsDetailPresenter extends BasePresenter<NewsDetailActivity> implements INewsDetailPresenter {
    public NewsDetailPresenter(NewsDetailActivity view) {
        super(view);
    }

    @Override
    public void loadWebView(WebView webView, String url) {

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (getView() != null) {
                    getView().init();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (getView() != null) {
                    getView().afterFinish();
                }
            }
        });


        try {
            webView.loadUrl(url);
        } catch (Exception e) {
            if (getView() != null) getView().err(getView().getString(R.string.err_network));

            e.printStackTrace();
        }
//        getView().afterFinish();


    }

    @Override
    public void requestNews() {

    }
}
