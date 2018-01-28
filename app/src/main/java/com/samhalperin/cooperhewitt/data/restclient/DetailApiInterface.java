package com.samhalperin.cooperhewitt.data.restclient;

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;

import retrofit.http.GET;
import retrofit.http.Query;

public interface DetailApiInterface {
    @GET("/?method=cooperhewitt.objects.getInfo")
    DetailObject getObject(
            @Query("access_token") String accessToken,
            @Query("object_id") String objectId);
}
