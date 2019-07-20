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
    public static final String API_KEY = "109a63e3da1d4c2393a65fca8bced3ed";

    public static Observable<ResponseModel> streamFetchGeneralNews(String country) {
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        return newsService.getFollowingGeneralNews(country, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
    public static Observable<ResponseModel> streamFetchSectionNews(String country, String category){
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        return  newsService.getFollowingSectionNews(country, category, API_KEY)
                           .subscribeOn(Schedulers.io())
                           .observeOn(AndroidSchedulers.mainThread())
                           .timeout(10, TimeUnit.SECONDS);
    }
    public static Observable<ResponseModel> streamFetchSectionNewsBySearch(String country,String category ,String query){
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        return  newsService.getSectionNewsBySearch(country, category,query ,API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }

}