package com.zarrouk.anis.mynews.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zarrouk.anis.mynews.Models.TopStoriesStream.Article;
import com.zarrouk.anis.mynews.Models.TopStoriesStream.Multimedia;
import com.zarrouk.anis.mynews.R;

import java.util.List;

/**
 * Created by Anis Zarrouk on 26/06/2019
 */
public class SportsAdapter extends  RecyclerView.Adapter<SportsAdapter.MyViewHolder> {

    List<Article> mNews ;


    public SportsAdapter(List<Article> news) { mNews = news; }

    @NonNull
    @Override
    public SportsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SportsAdapter.MyViewHolder holder, int position) {
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
            mTitleTextView = (TextView)itemView.findViewById(R.id.item_title);
            mDescriptionTextView = (TextView)itemView.findViewById(R.id.item_description);
            mImageView = (ImageView)itemView.findViewById(R.id.item_image);
        }

        public void display(Article article) {
            mTitleTextView.setText(article.getSection());
            mDescriptionTextView.setText(article.getTitle());
            for(Multimedia dataImage: article.getMultimedia()){
                if(dataImage.getFormat().equals("Standard Thumbnail") || dataImage.getFormat().equals("thumbnail")){
                    Picasso.get()
                            .load(article.getMultimedia().get(0).getUrl())
                            .into(mImageView);
                }
            }
        }
    }
}