package com.kuahusg.v2exwithmvp.HotNews.View;

import com.kuahusg.v2exwithmvp.HotNews.Model.News;

import java.util.List;

/**
 * Created by kuahusg on 16-7-25.
 */
public interface IHotNewsFramentView {
    void loadFinish(List<News> newsList);

    void loadErr();
}
