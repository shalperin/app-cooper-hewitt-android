package com.samhalperin.cooperhewitt.retrofit;

import android.os.AsyncTask;

import com.samhalperin.cooperhewitt.retrofit.SearchClient;
import com.samhalperin.cooperhewitt.ui.MainActivity;
import com.samhalperin.cooperhewitt.ui.maingridview.MainGridView;
import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.retrofit.pojo.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.retrofit.pojo.searchobjects.SearchObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sqh on 9/29/15.
 */
public class SearchTask extends AsyncTask<Integer, Void, List<SearchObject>> {
    private MainActivity mContext;
    private Integer mPage;
    private Integer mNPerPage;
    private Integer mPeriod;
    private MainGridView mHandler;

    public SearchTask(MainActivity context, MainGridView handler) {
        mContext = context;
        mHandler = handler;
    }

    protected List<SearchObject> doInBackground(Integer... params) {
        mPage = params[0];
        mNPerPage = params[1];
        mPeriod = params[2];
        SearchObjects s = SearchClient
                .getSearchApiClient()
                .searchData(
                        ((MyApplication) mContext.getApplication()).getAccessToken(),
                        mPage,
                        MyApplication.DEFAULT_PER_PAGE,
                        mPeriod
                );
        return filterOutItemsWithNoImages(s.getObjects());
    }

    @Override
    protected void onPostExecute(List<SearchObject> searchObjects) {
        mHandler.onData(mPage, mNPerPage, searchObjects);
    }

    private List<SearchObject> filterOutItemsWithNoImages(List<SearchObject> in) {
        List<SearchObject> filtered = new ArrayList<>();
        for (SearchObject o: in) {
            if (o.getImages().size() != 0) {
                filtered.add(o);
            }
        }
        return filtered;
    }
}
