package com.kuahusg.v2exwithmvp.Presenter;

import android.webkit.WebView;

/**
 * Created by kuahusg on 16-7-26.
 */
public interface INewsDetailPresenter extends INewsPresenter {
    void loadWebView(WebView webView, String url);
}
