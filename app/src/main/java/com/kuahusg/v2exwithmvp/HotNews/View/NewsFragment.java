package com.kuahusg.v2exwithmvp.HotNews.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuahusg.v2exwithmvp.HotNews.Interface.OnNewsItemClick;
import com.kuahusg.v2exwithmvp.HotNews.Model.News;
import com.kuahusg.v2exwithmvp.HotNews.Presenter.IHotNewsPresenter;
import com.kuahusg.v2exwithmvp.HotNews.View.Adapter.NewsListAdapter;
import com.kuahusg.v2exwithmvp.R;

import java.util.List;

/**
 * Created by kuahusg on 16-7-25.
 */
public class NewsFragment extends BaseFragment implements IHotNewsFramentView {
    private RecyclerView mRecyclerView;
    private IHotNewsPresenter mPresenter;
    private NewsListAdapter mAdapter;
    private List<News> newsList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rcv_news);
        mAdapter = new NewsListAdapter(newsList, new OnNewsItemClick() {
            @Override
            public void onClick(int position) {
                if (newsList != null || newsList.size() == 0) {
                    //// TODO: 16-7-25 start detail Activity
                }
            }
        });


        return view;
    }

    @Override
    public void setPresenter() {
        //// TODO: 16-7-25 write a presenter imple
    }

    @Override
    public void loadFinish(List<News> newsList) {
        this.newsList = newsList;
        mAdapter.setData(newsList);
    }

    @Override
    public void loadErr() {

    }
}
