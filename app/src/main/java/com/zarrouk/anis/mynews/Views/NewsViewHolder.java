package com.zarrouk.anis.mynews.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Anis Zarrouk on 13/07/2019
 */
public class NewsViewHolder  extends RecyclerView.ViewHolder {
    @BindView(R.id.item_image) ImageView mImageView;
    @BindView(R.id.item_title) TextView mTitleText;
    @BindView(R.id.item_description) TextView mDescriptionText;
    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void display(Article article){
        mTitleText.setText(article.getSource().getName());
        mDescriptionText.setText(article.getTitle());
        Picasso.get()
                .load(article.getUrlToImage())
                .resize(100, 100)
                .into(mImageView);
    }
}
