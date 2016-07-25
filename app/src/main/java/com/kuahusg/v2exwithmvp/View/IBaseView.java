package com.kuahusg.v2exwithmvp.View;

/**
 * Created by kuahusg on 16-7-25.
 */
public interface IBaseView {
    void init();

    void afterFinish();

    void err(String message);
}
