package com.kuahusg.v2exwithmvp.Presenter;

import com.kuahusg.v2exwithmvp.Model.Network.RetrofitManager;
import com.kuahusg.v2exwithmvp.Model.News;
import com.kuahusg.v2exwithmvp.View.Fragment.NewsFragment;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by kuahusg on 16-7-25.
 */
public class HotNewsFragPresenter extends BasePresenter<NewsFragment> implements INewsPresenter {

    public HotNewsFragPresenter(NewsFragment view) {

        super(view);
    }

    @Override
    public void requestNews() {
        RetrofitManager.getRetrofitManager().getV2exService().getHotNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        getView().init();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())    //getView().init() run on main Thread()
                .subscribe(new Observer<List<News>>() {
                    @Override
                    public void onCompleted() {
                        getView().afterFinish();
                    }

                    @Override
                    public void onError(Throwable e) {

                        if (getView() != null) getView().err(e.getMessage());
                        e.printStackTrace();

                    }

                    @Override
                    public void onNext(List<News> newses) {
                        if (getView() != null) getView().loadFinish(newses);

                    }
                });
    }



}
