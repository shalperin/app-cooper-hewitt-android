package com.samhalperin.cooperhewitt.data.repository;

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;

import java.util.List;

public interface RepositoryContract {

    public interface NewSearchPageLoadedCallbacks {
        void onNewPageLoaded(List<SearchObject> page);
    }

    public interface DetailObjectLoadedCallbacks {
        void onDetailObjectLoaded(DetailObject detailObject);
    }

    public void getDetailObject(String detailObjectId, DetailObjectLoadedCallbacks callbacks);

    public void getSearchPage(int pageNumber, int nPerPage, int period, NewSearchPageLoadedCallbacks callbacks);
}
