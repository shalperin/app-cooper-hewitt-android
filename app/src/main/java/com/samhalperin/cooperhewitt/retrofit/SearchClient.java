package com.samhalperin.cooperhewitt.retrofit;

import com.samhalperin.cooperhewitt.MyApplication;

import retrofit.RestAdapter;

/**
 * Created by sqh on 9/27/15.
 */
public class SearchClient {
    private static SearchApiInterface sSearchService;

    public static SearchApiInterface getSearchApiClient() {
        if (sSearchService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(MyApplication.API_ROOT)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            sSearchService = restAdapter.create(SearchApiInterface.class);
        }
        return sSearchService;
    }
}