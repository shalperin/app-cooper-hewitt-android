package com.samhalperin.cooperhewitt.data.restclient;

import android.os.AsyncTask;

import com.samhalperin.cooperhewitt.masterscreen.MasterActivity;
import com.samhalperin.cooperhewitt.masterscreen.maingridview.MainGridView;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sqh on 9/29/15.
 */
public class SearchTask extends AsyncTask<Integer, Void, List<SearchObject>> {
    private MasterActivity mContext;
    private Integer mPage;
    private Integer mNPerPage;
    private Integer mPeriod;
    private MainGridView mHandler;

    public SearchTask(MasterActivity context, MainGridView handler) {
        mContext = context;
        mHandler = handler;
    }

    protected List<SearchObject> doInBackground(Integer... params) {
        mPage = params[0];
        mNPerPage = params[1];
        mPeriod = params[2];
        SearchObjects s;

        try {
            s = SearchClient
                    .getSearchApiClient()
                    .searchData(
                            ((CooperHewittApplication) mContext.getApplication()).getAccessToken(),
                            mPage,
                            CooperHewittApplication.DEFAULT_PER_PAGE,
                            mPeriod
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<SearchObject>();
        }

        return filterOutItemsWithNoImages(s.getObjects());
    }

    @Override
    protected void onPostExecute(List<SearchObject> searchObjects) {
        mHandler.onData(searchObjects);
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
