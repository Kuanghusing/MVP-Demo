package com.kuahusg.v2exwithmvp.View.Fragment;

import com.kuahusg.v2exwithmvp.Model.News;
import com.kuahusg.v2exwithmvp.View.IBaseView;

import java.util.List;

/**
 * Created by kuahusg on 16-7-25.
 */
public interface IHotNewsFragmentView extends IBaseView{
    void loadFinish(List<News> newsList);

    @Override
    void afterFinish();

    @Override
    void err(String message);

    @Override
    void init();
}
