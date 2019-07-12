package com.zarrouk.anis.mynews.Utils;

import com.zarrouk.anis.mynews.Models.ResponseModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Anis Zarrouk on 10/07/2019
 */
public class NewsStreams {
    public static final String API_KEY="109a63e3da1d4c2393a65fca8bced3ed";
   /* public static Observable<ResponseModel> streamFetchGeneralNews(String country){
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        return newsService.getFollowingGeneralNews(API_KEY, country)
                          .observeOn(Schedulers.io())
                          .subscribeOn(AndroidSchedulers.mainThread())
                          .timeout(10, TimeUnit.SECONDS);*/

    }

