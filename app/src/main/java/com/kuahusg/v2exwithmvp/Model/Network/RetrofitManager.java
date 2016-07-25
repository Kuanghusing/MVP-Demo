package com.kuahusg.v2exwithmvp.Model.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kuahusg on 16-7-25.
 */
public class RetrofitManager {
    public static final String BASE_URL = "https://v2ex.com/";
    private Retrofit retrofit;
    private V2exService v2exService;

    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public V2exService getV2exService() {
        return retrofit.create(V2exService.class);

    }

    public static RetrofitManager getRetrofitManager() {
        return new RetrofitManager();
    }
}
