package com.samhalperin.cooperhewitt.data.repository

import android.app.Activity
import android.util.Log

import com.samhalperin.cooperhewitt.application.CooperHewittApplication
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects
import com.samhalperin.cooperhewitt.data.restclient.RestService

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

class Repository(context: Activity) : RepositoryContract {
    private val apiKey = (context.application as CooperHewittApplication).accessToken
    private val restService = RestService()

    override fun getDetailObject(detailObjectId: String, callbacks: (DetailObject)->Unit) {
        val call = restService.service.getObject(apiKey, detailObjectId)
        call.enqueue(object : Callback<DetailObject> {
            override fun onResponse(call: Call<DetailObject>, response: Response<DetailObject>) {
                if (response.isSuccessful) {
                    var body = response.body()
                    if (body != null) {
                        callbacks(body)
                    }
                } else {
                    Log.e("Repository Rest Service", "Response was not success")
                }
            }

            override fun onFailure(call: Call<DetailObject>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun getSearchPage(pageNumber: Int, nPerPage: Int, period: Int, callbacks: (List<SearchObject>) -> Unit) {
        val call = restService.service.getSearchData(
                apiKey,
                pageNumber,
                nPerPage,
                period
        )
        call.enqueue(object : Callback<SearchObjects> {
            override fun onResponse(call: Call<SearchObjects>, response: Response<SearchObjects>) {
                if (response.isSuccessful) {
                    val filtered = ArrayList<SearchObject>()
                    val body = response.body()
                    if (body != null) {
                        for (o in body.objects) {
                            if (o.images.size != 0) {
                                filtered.add(o)
                            }
                        }
                    }
                    callbacks(filtered)
                } else {
                    Log.e("Repository Rest Service", "Response was not success")
                }
            }

            override fun onFailure(call: Call<SearchObjects>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}