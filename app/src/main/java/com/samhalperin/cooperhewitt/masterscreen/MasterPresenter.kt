package com.samhalperin.cooperhewitt.masterscreen

import com.samhalperin.cooperhewitt.application.CooperHewittApplication
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract

class MasterPresenter(private val mView: MasterContract.View, private val mRepository: RepositoryContract) : MasterContract.UserActionHandler {
    private var mArtisticPeriodSelected: Int = 0

    override fun selectArtisticPeriod(id: Int) {
        mArtisticPeriodSelected = id
    }

    override fun loadPage(pageNumber: Int, clear: Boolean) {
        if (clear)
            mView.clearResults()
        mView.displayProgressBar()
        mRepository.getSearchPage(
                pageNumber,
                CooperHewittApplication.DEFAULT_PER_PAGE,
                mArtisticPeriodSelected
        ) { page ->
            mView.displayPage(page)
            mView.hideProgressBar()
        }
    }

    override fun navigateToDetailActivity(id: String) {
        mView.navigateToDetailActivity(id)
    }

    override fun navigateToAboutActivity() {
        mView.navigateToAboutActivity()
    }
}
