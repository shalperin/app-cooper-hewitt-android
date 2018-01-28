package com.samhalperin.cooperhewitt.masterscreen;

import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects;
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract;

import java.util.List;

public interface MasterContract {

    public interface View {
        void navigateToAboutActivity();
        void navigateToDetailActivity(String id);
        void displayPage(List<SearchObject> items);
        void displayProgressBar();
        void hideProgressBar();
        void clearResults();

    }

    public interface UserActionHandler {
        void loadPage(int pageNumber, boolean clear);
        void selectArtisticPeriod(int period);
        void navigateToDetailActivity(String id);
        void navigateToAboutActivity();
    }
}
