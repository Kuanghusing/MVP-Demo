package com.kuahusg.v2exwithmvp.HotNews.View;

import android.support.v4.app.Fragment;

import com.kuahusg.v2exwithmvp.HotNews.Presenter.IHotNewsPresenter;

/**
 * Created by kuahusg on 16-7-25.
 */
public abstract class BaseFragment extends Fragment {
    IHotNewsPresenter presenter;

    public abstract void setPresenter();

    public IHotNewsPresenter getPresenter() {
        return presenter;
    }
    public BaseFragment() {
        setPresenter();
    }
}
