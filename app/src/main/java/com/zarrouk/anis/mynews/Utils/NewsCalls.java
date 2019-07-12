package com.zarrouk.anis.mynews.Utils;

import android.util.Log;

import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.Models.ResponseModel;

import org.json.JSONException;

import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anis Zarrouk on 06/07/2019
 */
public class NewsCalls {



   public static final String API_KEY="109a63e3da1d4c2393a65fca8bced3ed";
    public interface  CallBacks{
        void onResponse(List<Article> posts);
        void onFailure();
    }



   public static void fetchGeneralNews(CallBacks callbacks, String country){
        final WeakReference<CallBacks> callBacksWeakReference = new WeakReference<>(callbacks);
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        Call<ResponseModel> call = newsService.getFollowingGeneralNews(country, API_KEY);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call,Response<ResponseModel> response) {
                if(callBacksWeakReference.get()!=null){
                    callBacksWeakReference.get().onResponse(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                if(callBacksWeakReference.get()!=null){
                    callBacksWeakReference.get().onFailure();
                }

            }
        });



    }
    public static void fetchSectionNews(CallBacks callbacks, String country, String category){
        final WeakReference<CallBacks> callBacksWeakReference = new WeakReference<>(callbacks);
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        Call<ResponseModel> call = newsService.getFollowingSectionNews(country,category, API_KEY);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call,Response<ResponseModel> response) {
                if(callBacksWeakReference.get()!=null){
                    callBacksWeakReference.get().onResponse(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                if(callBacksWeakReference.get()!=null){
                    callBacksWeakReference.get().onFailure();
                }
            }
        });



    }



}
