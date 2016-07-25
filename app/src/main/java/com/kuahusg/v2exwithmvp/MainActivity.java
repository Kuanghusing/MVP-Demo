package com.kuahusg.v2exwithmvp;

import android.os.Bundle;

import com.kuahusg.v2exwithmvp.HotNews.View.BaseActivity;
import com.kuahusg.v2exwithmvp.HotNews.View.IHotNewsActivityView;

public class MainActivity extends BaseActivity implements IHotNewsActivityView {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setPresenter() {
        //// TODO: 16-7-25 write a presenter impl
    }

    @Override
    public void loadFinish() {

    }

    @Override
    public void loadErr(String message) {

    }

    @Override
    public void loading() {

    }
}
