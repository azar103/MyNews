package com.zarrouk.anis.mynews.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.R;

import java.util.List;

/**
 * Created by Anis Zarrouk on 26/06/2019
 */
public class SportsAdapter extends  RecyclerView.Adapter<NewsViewHolder> {

    List<Article> mArticles;

    public SportsAdapter(List<Article> news) {
        mArticles = news;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.list_item, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder newsViewHolder, int position) {
             newsViewHolder.display(mArticles.get(position));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}