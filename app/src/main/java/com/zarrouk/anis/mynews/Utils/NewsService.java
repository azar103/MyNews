package com.zarrouk.anis.mynews.Utils;

import com.zarrouk.anis.mynews.Models.ResponseModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anis Zarrouk on 06/07/2019
 */
 public interface NewsService {
    @GET("topstories/v2/home.json")
    Observable<ResponseModel> getFollowingTopStories(@Query("api-key") String API_KEY);

    @GET("mostpopular/v2/viewed/1.json")
    Call<ResponseModel> getFollowingMostPopular(@Query("api-key") String API_KEY);

    @GET("topstories/v2/sports.json")
    Call<ResponseModel> getSportsSection(@Query("api-key") String API_KEY);

    Retrofit retrofit = new Retrofit.Builder()
                                       .addConverterFactory(GsonConverterFactory.create())
                                       .baseUrl("https://api.nytimes.com/svc/")
                                       .build();

 }
