package com.zarrouk.anis.mynews.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.R;

import java.util.List;

/**
 * Created by Anis Zarrouk on 15/07/2019
 */
public class BaseAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    protected List<Article> mArticles;
    protected RequestManager glide;


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {
        newsViewHolder.display(mArticles.get(position), this.glide);
    }


    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public Article getArticle(int position){
        return mArticles.get(position);
    }

}
