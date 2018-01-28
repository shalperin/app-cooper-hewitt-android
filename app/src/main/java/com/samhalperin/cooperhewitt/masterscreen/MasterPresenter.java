package com.samhalperin.cooperhewitt.masterscreen;

import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract;

import java.util.List;

public class MasterPresenter implements MasterContract.UserActionHandler{
    private MasterContract.View mView;
    private RepositoryContract mRepository;
    private int mArtisticPeriodSelected;

    public MasterPresenter(MasterContract.View view, RepositoryContract repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void selectArtisticPeriod(int id) {
        mArtisticPeriodSelected = id;
    }

    @Override
    public void loadPage(int pageNumber, boolean clear) {
        if (clear)
            mView.clearResults();
        mView.displayProgressBar();
        mRepository.getSearchPage(pageNumber, CooperHewittApplication.DEFAULT_PER_PAGE,
                mArtisticPeriodSelected, new RepositoryContract.NewSearchPageLoadedCallbacks() {
                    @Override
                    public void onNewPageLoaded(List<SearchObject> page) {
                        mView.displayPage(page);
                        mView.hideProgressBar();
                    }
                }
        );
    }

    @Override
    public void navigateToDetailActivity(String id) {
        mView.navigateToDetailActivity(id);
    }

    @Override
    public void navigateToAboutActivity() {
        mView.navigateToAboutActivity();
    }
}
