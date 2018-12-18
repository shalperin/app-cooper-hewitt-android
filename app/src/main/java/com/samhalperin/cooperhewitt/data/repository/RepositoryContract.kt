package com.samhalperin.cooperhewitt.data.repository

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject

interface RepositoryContract {

    fun getDetailObject(detailObjectId: String, callbacks: (DetailObject) -> Unit)

    fun getSearchPage(pageNumber: Int, nPerPage: Int, period: Int, callbacks: (List<SearchObject>) -> Unit)
}
