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
 * Created by Anis Zarrouk on 13/07/201
 */
public class GeneralAdapter extends BaseAdapter{

    public GeneralAdapter(List<Article> articles, RequestManager glide) {
        mArticles = articles;
        this.glide = glide;
    }

}
