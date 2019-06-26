package com.zarrouk.anis.mynews.Utils;

import android.os.AsyncTask;
import android.support.v4.content.AsyncTaskLoader;

import java.lang.ref.WeakReference;

/**
 * Created by Anis Zarrouk on 26/06/2019
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Long>{
    private final WeakReference<Listeners> mCallBack;
    public interface Listeners{
        void onPostExecute(Long succes);
        void onPreExecute();
        void doInBackground();
    }

    public MyAsyncTask(Listeners callBack) {
        mCallBack =  new WeakReference<>(callBack);
    }



    @Override
    protected void onPostExecute(Long succes) {
        super.onPostExecute(succes);
        mCallBack.get().onPostExecute(succes);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCallBack.get().onPreExecute();
    }

    @Override
    protected Long doInBackground(Void... voids) {
        mCallBack.get().doInBackground();
        return Utils.executeTaskAfter7Seconds();
    }
}
