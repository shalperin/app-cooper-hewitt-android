package com.samhalperin.cooperhewitt.data.restclient;

import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by sqh on 9/27/15.
 */
public interface SearchApiInterface {
    @GET("/?method=cooperhewitt.search.objects&has_images=1")
    SearchObjects searchData(
            @Query("access_token") String accessToken,
            @Query("page") int page,
            @Query("per_page") int nPerPage,
            @Query("period_id") int periodId);


}
