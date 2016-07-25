package com.kuahusg.v2exwithmvp.View.Fragment;

import android.support.v4.app.Fragment;

import com.kuahusg.v2exwithmvp.Presenter.BasePresenter;

/**
 * Created by kuahusg on 16-7-25.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    T presenter;

    public abstract T setPresenter();

    public T getPresenter() {
        return presenter;
    }
    public BaseFragment() {
        presenter = setPresenter();
    }
}
