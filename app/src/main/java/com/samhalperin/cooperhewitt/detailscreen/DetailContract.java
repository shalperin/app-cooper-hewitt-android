package com.samhalperin.cooperhewitt.detailscreen;

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;

/**
 * Created by samhalperin on 1/27/18.
 */

public interface DetailContract {

    public interface View {
        void displayDetailObject(DetailObject detailObject);
        void shareDetailObject(DetailObject detailObject);
    }

    public interface UserActionsHandler {
        void loadDetailObject(String id);
        void shareDetailObject(String id);
    }
}
