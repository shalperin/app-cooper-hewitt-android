package com.samhalperin.cooperhewitt.masterscreen

import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract

interface MasterContract {

    interface View {
        fun navigateToAboutActivity()
        fun navigateToDetailActivity(id: String)
        fun displayPage(items: List<SearchObject>)
        fun displayProgressBar()
        fun hideProgressBar()
        fun clearResults()

    }

    interface UserActionHandler {
        fun loadPage(pageNumber: Int, clear: Boolean)
        fun selectArtisticPeriod(period: Int)
        fun navigateToDetailActivity(id: String)
        fun navigateToAboutActivity()
    }
}
