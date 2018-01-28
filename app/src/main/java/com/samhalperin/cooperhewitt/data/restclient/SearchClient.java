package com.samhalperin.cooperhewitt.data.restclient;

import com.samhalperin.cooperhewitt.application.CooperHewittApplication;

import retrofit.RestAdapter;

public class SearchClient {
    private static SearchApiInterface sSearchService;

    public static SearchApiInterface getSearchApiClient() {
        if (sSearchService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(CooperHewittApplication.API_ROOT)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            sSearchService = restAdapter.create(SearchApiInterface.class);
        }
        return sSearchService;
    }
}