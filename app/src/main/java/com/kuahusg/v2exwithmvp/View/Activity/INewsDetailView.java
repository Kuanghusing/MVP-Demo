package com.kuahusg.v2exwithmvp.View.Activity;

import com.kuahusg.v2exwithmvp.View.IBaseView;

/**
 * Created by kuahusg on 16-7-26.
 */
public interface INewsDetailView extends IBaseView {
    @Override
    void afterFinish();

    @Override
    void err(String message);

    @Override
    void init();


}
