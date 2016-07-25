package com.kuahusg.v2exwithmvp.View.Activity;

import com.kuahusg.v2exwithmvp.View.IBaseView;

/**
 * Created by kuahusg on 16-7-25.
 */
public interface IHotNewsActivityView extends IBaseView{

    void loadFinish();


    @Override
    void afterFinish();

    @Override
    void err(String message);

    @Override
    void init();
}
