package com.zarrouk.anis.mynews.Utils;

import android.util.Log;

import com.zarrouk.anis.mynews.Models.ResponseModel;

import org.json.JSONException;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.zarrouk.anis.mynews.Models.TopStoriesStream.Article;
/**
 * Created by Anis Zarrouk on 06/07/2019
 */
public class NewsCalls {

    public static final String API_KEY_1 ="VqIqRqFQKLeyiCKr2o0Fo3vQuKqMPAH1";
    public static final String API_KEY_2 ="cf9fR8GDGUcRfZAytsAfpzOPL8w50KK8";


    public interface  CallBacks{
        void onResponse(List<Article> posts);
        void onFailure();
    }



   public static void fetchTopStories(CallBacks callbacks){

    }
    /*public static void fetchMostPopular(CallBacks callbacks){
        final  WeakReference<CallBacks> callBacksWeakReference = new WeakReference<CallBacks>(callbacks);
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        Call<ResponseModel> call2 = newsService.getFollowingMostPopular(API_KEY_2);
        call2.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(callBacksWeakReference.get()!=null){
                    callBacksWeakReference.get().onResponse(response.body().getResults());
                    Log.d("TAG",response.body().getResults().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                callBacksWeakReference.get().onFailure();
            }
        });
    }

    public static void fetchSports(CallBacks callbacks){
        final  WeakReference<CallBacks> callBacksWeakReference = new WeakReference<CallBacks>(callbacks);
        NewsService newsService = NewsService.retrofit.create(NewsService.class);
        Call<ResponseModel> call = newsService.getSportsSection(API_KEY_2);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(callBacksWeakReference.get()!=null){
                    callBacksWeakReference.get().onResponse(response.body().getResults());
                }
            }
            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                callBacksWeakReference.get().onFailure();
            }
        });
    }*/
}
