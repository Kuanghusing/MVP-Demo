package com.kuahusg.v2exwithmvp.HotNews.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.kuahusg.v2exwithmvp.HotNews.Presenter.IHotNewsPresenter;
import com.kuahusg.v2exwithmvp.R;
import com.kuahusg.v2exwithmvp.Util.StatusBarUtil;

/**
 * Created by kuahusg on 16-7-25.
 */
public abstract class BaseActivity<T extends IHotNewsPresenter> extends AppCompatActivity {
    T presenter;

    public T getPresenter() {
        return presenter;
    }

    public abstract void setPresenter();

    public abstract int setLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());

        setPresenter();
        initStatusBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public void initStatusBar() {
        StatusBarUtil.setupStatusBar((FrameLayout) findViewById(R.id.status_bar), ContextCompat
                .getColor(this, R.color.colorPrimaryDark), this);

    }

    public Toolbar setToolbar(String title, int id) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(title);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(id);
        }
        return toolbar;
    }
}
