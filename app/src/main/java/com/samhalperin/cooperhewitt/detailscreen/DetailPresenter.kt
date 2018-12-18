package com.samhalperin.cooperhewitt.detailscreen

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract

class DetailPresenter(private val mView: DetailContract.View, private val mRepository: RepositoryContract) : DetailContract.UserActionsHandler {

    override fun loadDetailObject(id: String) {
        mRepository.getDetailObject(
                id
        ) { detailObject: DetailObject -> mView.displayDetailObject(detailObject) }
    }

    override fun shareDetailObject(id: String) {
        mRepository.getDetailObject(
                id
        ) { detailObject:DetailObject -> mView.shareDetailObject(detailObject) }
    }
}
