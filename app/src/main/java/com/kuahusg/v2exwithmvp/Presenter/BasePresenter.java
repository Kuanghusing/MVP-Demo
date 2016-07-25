package com.kuahusg.v2exwithmvp.Presenter;

import com.kuahusg.v2exwithmvp.View.IBaseView;

/**
 * Created by kuahusg on 16-7-25.
 */
public class BasePresenter<T extends IBaseView> {
    T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }
    public void onViewDestroy() {
        view = null;

    }
}
