package com.kuahusg.v2exwithmvp.Model.Network;

import com.kuahusg.v2exwithmvp.Model.News;


import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by kuahusg on 16-7-25.
 */
public interface V2exService {
    @GET("api/topics/hot.json")
    Observable<List<News>> getHotNews();

}

