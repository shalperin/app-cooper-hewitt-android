package com.samhalperin.cooperhewitt.data.repository;

import android.app.Activity;
import android.util.Log;

import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects;
import com.samhalperin.cooperhewitt.data.restclient.RestService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private RestService mRestService;

    public Repository(Activity context) {
        mApiKey = ((CooperHewittApplication)context.getApplication()).getAccessToken();
        mRestService = new RestService();
    }

    @Override
    public void getDetailObject(String detailObjectId, final DetailObjectLoadedCallbacks callbacks) {
       Call<DetailObject> call = mRestService.service.getObject(mApiKey, detailObjectId);
       call.enqueue(new Callback<DetailObject>() {
           @Override
           public void onResponse(Call<DetailObject> call, Response<DetailObject> response) {
               if (response.isSuccessful()) {
                   callbacks.onDetailObjectLoaded(response.body());
               } else {
                   Log.e("Repository Rest Service", "Response was not success");
               }
           }

           @Override
           public void onFailure(Call<DetailObject> call, Throwable t) {
                t.printStackTrace();
           }
       });
    }

    @Override
    public void getSearchPage(int pageNumber, int nPerPage, int period, final NewSearchPageLoadedCallbacks callbacks) {
        Call<SearchObjects> call = mRestService.service.getSearchData(
                mApiKey,
                pageNumber,
                nPerPage,
                period
                );
        call.enqueue(new Callback<SearchObjects>() {
            @Override
            public void onResponse(Call<SearchObjects> call, Response<SearchObjects> response) {
                if (response.isSuccessful()) {
                    List<SearchObject> filtered = new ArrayList<>();
                    for (SearchObject o: response.body().getObjects()) {
                        if (o.getImages().size() != 0) {
                            filtered.add(o);
                        }
                    }
                    callbacks.onNewPageLoaded(filtered);
                } else {
                    Log.e("Repository Rest Service", "Response was not success");
                }
            }

            @Override
            public void onFailure(Call<SearchObjects> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}