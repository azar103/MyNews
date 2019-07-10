package com.zarrouk.anis.mynews.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zarrouk.anis.mynews.Models.MostPopularStream.ArticleMostPopular;
import com.zarrouk.anis.mynews.R;

import java.util.List;

/**
 * Created by Anis Zarrouk on 25/06/2019
 */
public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MyViewHolder> {
    List<ArticleMostPopular> mNews;

    public MostPopularAdapter(List<ArticleMostPopular> news) {
        mNews = news;
    }

    @Override
    public MostPopularAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MostPopularAdapter.MyViewHolder holder, int position) {
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
            mTitleTextView = (TextView) itemView.findViewById(R.id.item_title);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.item_description);
        }

        public void display(ArticleMostPopular article) {
            mTitleTextView.setText(article.getSection());
            mDescriptionTextView.setText(article.getTitle());

        }
    }

}