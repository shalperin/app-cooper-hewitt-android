package com.samhalperin.cooperhewitt.data.restclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by samhalperin on 1/28/18.
 */

public class RestService {
    public interface CooperHewittService {

        @GET("/rest?method=cooperhewitt.objects.getInfo")
        Call<DetailObject> getObject(
                @Query("access_token") String accessToken,
                @Query("object_id") String objectId
        );

        @GET("/rest?method=cooperhewitt.search.objects&has_images=1")
        Call<SearchObjects> getSearchData(
                @Query("access_token") String accessToken,
                @Query("page") int page,
                @Query("per_page") int nPerPage,
                @Query("period_id") int periodId
        );

    }

    public CooperHewittService service;

    public RestService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CooperHewittApplication.API_ROOT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(CooperHewittService.class);

    }
}
