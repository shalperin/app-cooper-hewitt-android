package com.samhalperin.cooperhewitt.detailscreen;

import android.content.Context;

import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract;

public class DetailPresenter implements DetailContract.UserActionsHandler {
    private RepositoryContract mRepository;
    private DetailContract.View mView;

    public DetailPresenter(DetailContract.View view, RepositoryContract repository) {
        mRepository = repository;
        mView = view;
    }

    @Override
    public void loadDetailObject(String id) {
        mRepository.getDetailObject(
                id,
                new RepositoryContract.DetailObjectLoadedCallbacks() {
                    @Override
                    public void onDetailObjectLoaded(DetailObject detailObject) {
                        mView.displayDetailObject(detailObject);
                    }
                });
    }

    @Override
    public void shareDetailObject(String id) {
        mRepository.getDetailObject(
                id,
                new RepositoryContract.DetailObjectLoadedCallbacks() {
                    @Override
                    public void onDetailObjectLoaded(DetailObject detailObject) {
                        mView.shareDetailObject(detailObject);
                    }
                });
    }
}
