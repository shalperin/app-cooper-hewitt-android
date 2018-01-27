package com.samhalperin.cooperhewitt.data.restclient;

import com.samhalperin.cooperhewitt.application.CooperHewittApplication;

import retrofit.RestAdapter;

/**
 * Created by sqh on 9/27/15.
 */
public class DetailClient {
    private static DetailApiInterface sDetailService;

    public static DetailApiInterface getDetailApiClient() {
        if (sDetailService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(CooperHewittApplication.API_ROOT)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            sDetailService = restAdapter.create(DetailApiInterface.class);
        }
        return sDetailService;
    }
}