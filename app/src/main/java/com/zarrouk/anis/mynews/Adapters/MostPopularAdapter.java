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
public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MyViewHolder> {
    List<News> mNews;


    public MostPopularAdapter(List<News> news) {
        mNews = news;
    }

    @Override
    public MostPopularAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int position) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MostPopularAdapter.MyViewHolder holder, int position) {
        holder.display(mNews.get(position));
    }



    @Override
    public int getItemCount() {
        return mNews.size();
    }


    public class MyViewHolder  extends RecyclerView.ViewHolder {
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
