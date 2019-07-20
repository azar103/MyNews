package com.zarrouk.anis.mynews.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.DateUtilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Anis Zarrouk on 13/07/2019
 */
public class NewsViewHolder  extends RecyclerView.ViewHolder {
    @BindView(R.id.item_image) ImageView mImageView;
    @BindView(R.id.item_title) TextView mTitleText;
    @BindView(R.id.item_description) TextView mDescriptionText;
    @BindView(R.id.item_date) TextView mDateText;
    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void display(Article article, RequestManager glide){
        mTitleText.setText(article.getSource().getName());
        mDescriptionText.setText(article.getTitle());
        String date = DateUtilities.dateReformat(article.getPublishedAt());
        mDateText.setText(date);
        glide.load(article.getUrlToImage()).apply(RequestOptions.centerCropTransform()).into(mImageView);

    }
}
