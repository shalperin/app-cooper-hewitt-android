package com.samhalperin.cooperhewitt.retrofit;

import android.app.Activity;
import android.os.AsyncTask;

import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.retrofit.DetailClient;
import com.samhalperin.cooperhewitt.retrofit.pojo.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.ui.detailview.DetailView;

/**
 * Created by sqh on 9/29/15.
 */
public class DetailTask extends AsyncTask<String, Void, DetailObject> {
    private DetailView mHandler;
    private Activity mContext;

    public DetailTask(Activity context, DetailView handler) {
        mHandler = handler;
        mContext = context;
    }

    protected DetailObject doInBackground(String... params) {
        String id = params[0];

        DetailObject d = new DetailObject();
        try {
            d = DetailClient
                    .getDetailApiClient()
                    .getObject(
                            ((MyApplication) mContext.getApplication()).getAccessToken(),
                            id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return d;


    }

    @Override
    protected void onPostExecute(DetailObject data) {
        mHandler.onData(data);
    }

}