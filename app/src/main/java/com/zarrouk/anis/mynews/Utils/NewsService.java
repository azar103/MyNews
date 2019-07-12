package com.zarrouk.anis.mynews.Utils;

import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.Models.ResponseModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Anis Zarrouk on 06/07/2019
 */
 public interface NewsService {
    @GET("v2/top-headlines")
    Call<ResponseModel> getFollowingGeneralNews(
            @Query("country") String country,
            @Query("apiKey") String API_KEY);

    @GET("v2/top-headlines")
    Call<ResponseModel> getFollowingSectionNews(
                                           @Query("country") String country,
                                           @Query("category") String category,
                                             @Query("apiKey") String API_KEY
                                                );


    Retrofit retrofit = new Retrofit.Builder()
                                       .addConverterFactory(GsonConverterFactory.create())
                                       .baseUrl("https://newsapi.org/")
                                       .build();

 }
