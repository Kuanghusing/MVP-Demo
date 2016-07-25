package com.kuahusg.v2exwithmvp.HotNews.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kuahusg.v2exwithmvp.HotNews.Interface.OnNewsItemClick;
import com.kuahusg.v2exwithmvp.HotNews.Model.News;
import com.kuahusg.v2exwithmvp.R;

import java.util.List;

/**
 * Created by kuahusg on 16-7-25.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.VH> {
    private List<News> newsList;
    private OnNewsItemClick newsItemClick;
    static Context sContext;


    public NewsListAdapter(List<News> newsList, OnNewsItemClick newsItemClick) {
        this.newsList = newsList;
        this.newsItemClick = newsItemClick;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        sContext = parent.getContext();
        View itemView = LayoutInflater.from(sContext).inflate(R.layout.news_item, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        News news = newsList.get(position);
        holder.tvUserName.setText(news.getMember().getUsername());
        holder.tvNode.setText(news.getNode().getName());
        holder.tvTitle.setText(news.getTitle());
        Glide.with(sContext).load("http:" + news.getMember().getAvatar_normal()).into(holder.imgUserIcon);


    }

    public void setData(List<News> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        this.notifyDataSetChanged();
    }

    public class VH extends RecyclerView.ViewHolder {
        View itemView;
        ImageView imgUserIcon;
        TextView tvUserName;
        TextView tvNode;
        TextView tvTitle;

        public VH(View itemView) {
            super(itemView);
            this.itemView = itemView;
            imgUserIcon = (ImageView) itemView.findViewById(R.id.img_user_icon);
            tvNode = (TextView) itemView.findViewById(R.id.txt_node);
            tvUserName = (TextView) itemView.findViewById(R.id.txt_username);
            tvTitle = (TextView) itemView.findViewById(R.id.news_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (newsItemClick != null) {
                        newsItemClick.onClick(VH.this.getAdapterPosition());
                        Log.d(VH.this.toString(), "onclick position" + VH.this.getAdapterPosition() + "");
                    }
                }
            });
        }
    }
}




