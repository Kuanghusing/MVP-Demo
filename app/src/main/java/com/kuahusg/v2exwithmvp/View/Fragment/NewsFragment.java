package com.kuahusg.v2exwithmvp.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.request.ResourceCallback;
import com.kuahusg.v2exwithmvp.Interface.OnNewsItemClick;
import com.kuahusg.v2exwithmvp.Interface.RequestDataCallback;
import com.kuahusg.v2exwithmvp.Model.News;
import com.kuahusg.v2exwithmvp.Presenter.HotNewsFragPresenter;
import com.kuahusg.v2exwithmvp.R;
import com.kuahusg.v2exwithmvp.View.Adapter.NewsListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuahusg on 16-7-25.
 */
public class NewsFragment extends BaseFragment<HotNewsFragPresenter> implements IHotNewsFragmentView {
    private RecyclerView mRecyclerView;
    private NewsListAdapter mAdapter;
    private List<News> newsList;
    private RequestDataCallback callback;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rcv_news);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList = new ArrayList<>();
        mAdapter = new NewsListAdapter(newsList, new OnNewsItemClick() {
            @Override
            public void onClick(int position) {
                if (newsList != null || newsList.size() == 0) {
                    // TODO: 16-7-25 start detail Activity
                    Toast.makeText(getContext(), "you click " + position,Toast.LENGTH_SHORT).show();
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        if (newsList == null || newsList.size() == 0) {
            getPresenter().requestNews();
        }


        return view;
    }

    @Override
    public HotNewsFragPresenter setPresenter() {
        return new HotNewsFragPresenter(this);
    }

    @Override
    public void afterFinish() {
//        Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void err(String message) {
        if (callback != null) {
            callback.err(message);
        }
    }

    @Override
    public void init() {
//        Toast.makeText(getActivity(), "refreshing...", Toast.LENGTH_SHORT).show();
        if (callback != null) {
            callback.init();
        }
    }

    @Override
    public void loadFinish(List<News> newsList) {
        this.newsList = newsList;
        mAdapter.setData(newsList);
        if (callback != null) {
            callback.finish();
        }
    }

    public void requestDataCallback(RequestDataCallback callback) {
        this.callback = callback;
    }

}