package com.zarrouk.anis.mynews.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zarrouk.anis.mynews.Models.News;
import com.zarrouk.anis.mynews.R;

import java.util.List;

/**
 * Created by Anis Zarrouk on 26/06/2019
 */
public class WorldAdapter extends  RecyclerView.Adapter<WorldAdapter.MyViewHolder> {

    List<News> mNews;


    public WorldAdapter(List<News> news) {
        mNews = news;
    }

    @NonNull
    @Override
    public WorldAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldAdapter.MyViewHolder holder, int position) {
        holder.display(mNews.get(position));

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView)itemView.findViewById(R.id.item_title);
            mDescriptionTextView = (TextView)itemView.findViewById(R.id.item_description);

        }

        public void display(News news) {
            mTitleTextView.setText(news.getTitle());
            mDescriptionTextView.setText(news.getDescription());
        }
    }
}
