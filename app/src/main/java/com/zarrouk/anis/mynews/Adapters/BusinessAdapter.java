package com.zarrouk.anis.mynews.Adapters;

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
 * Created by Anis Zarrouk on 25/06/2019
 */
public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.MyViewHolder> {
    List<Article> mNews;

    public BusinessAdapter(List<Article> news) {
        mNews = news;
    }

    @Override
    public BusinessAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BusinessAdapter.MyViewHolder holder, int position) {
        holder.display(mNews.get(position));
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        private ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.item_title);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.item_description);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image);
        }

        public void display(Article article) {
            mTitleTextView.setText(article.getSource().getName());
            mDescriptionTextView.setText(article.getTitle());
            Picasso.get()
                    .load(article.getUrlToImage())
                    .resize(200, 200)
                    .into(mImageView);

        }
    }

}