package com.samhalperin.cooperhewitt.data.repository;

import android.app.Activity;
import android.os.AsyncTask;

import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.restclient.DetailClient;
import com.samhalperin.cooperhewitt.data.restclient.SearchClient;
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects;
import com.samhalperin.cooperhewitt.masterscreen.MasterActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * So far we haven't needed any kind of caching on this repository,
 * so calls to GetDetailObject and getSearchPage just pass right through
 * to the REST endpoints.
 *
 * Actually that is no longer true for the following specific case:
 * In the detail view, the object is loaded automatically, but reloaded
 * on share.  So caching is now a TODO.
 *
 */

public class Repository implements RepositoryContract {
    private String mApiKey;

    public Repository(Activity context) {
        mApiKey = ((CooperHewittApplication)context.getApplication()).getAccessToken();
    }

    @Override
    public void getDetailObject(String detailObjectId, DetailObjectLoadedCallbacks callbacks) {
        DetailTask task = new DetailTask(mApiKey, callbacks);
        task.execute(detailObjectId);
    }

    @Override
    public void getSearchPage(int pageNumber, int nPerPage, String period, NewSearchPageLoadedCallbacks callbacks) {
        SearchTask task = new SearchTask(mApiKey, callbacks);
    }

    private class DetailTask extends AsyncTask<String, Void, DetailObject> {
        private DetailObjectLoadedCallbacks mHandler;
        private Activity mContext;
        private String mApiKey;

        public DetailTask(String apiKey, DetailObjectLoadedCallbacks handler) {
            mHandler = handler;
            mApiKey = apiKey;
        }

        protected DetailObject doInBackground(String... params) {
            String id = params[0];

            DetailObject d = new DetailObject();
            try {
                d = DetailClient
                        .getDetailApiClient()
                        .getObject(
                                mApiKey,
                                id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return d;
        }

        @Override
        protected void onPostExecute(DetailObject detailObject) {
            if (mHandler != null) {
                mHandler.onDetailObjectLoaded(detailObject);
            }
        }

    }


    private class SearchTask extends AsyncTask<Integer, Void, List<SearchObject>> {
        private MasterActivity mContext;
        private Integer mPage;
        private Integer mNPerPage;
        private Integer mPeriod;
        private NewSearchPageLoadedCallbacks mHandler;
        private String mApiKey;

        public SearchTask(String apiKey, NewSearchPageLoadedCallbacks callbacks) {
            mApiKey = apiKey;
            mHandler = callbacks;
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
                                mApiKey,
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
            if (mHandler != null) {
                mHandler.onNewPageLoaded(searchObjects);
            }
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

}
