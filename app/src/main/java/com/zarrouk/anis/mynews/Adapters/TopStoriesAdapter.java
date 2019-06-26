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
 * Created by Anis Zarrouk on 25/06/2019
 */
public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.MyViewHolder> {
    List<News> myNews;

    public TopStoriesAdapter(List<News> myNews) {
        this.myNews = myNews;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
             holder.display(myNews.get(position));
    }

    @Override
    public int getItemCount() {
        return myNews.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTitleTextView  = (TextView)itemView.findViewById(R.id.item_title);
            mDescriptionTextView = (TextView)itemView.findViewById(R.id.item_description);
        }

        public void display(News news) {
            mTitleTextView.setText(news.getTitle());
            mDescriptionTextView.setText(news.getDescription());
        }
    }
}