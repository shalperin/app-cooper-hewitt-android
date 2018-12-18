package com.samhalperin.cooperhewitt.detailscreen

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject

interface DetailContract {

    interface View {
        fun displayDetailObject(detailObject: DetailObject)
        fun shareDetailObject(detailObject: DetailObject)
    }

    interface UserActionsHandler {
        fun loadDetailObject(id: String)
        fun shareDetailObject(id: String)
    }
}
