package com.samhalperin.cooperhewitt.ui.maingridview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.samhalperin.cooperhewitt.Controller;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.retrofit.SearchTask;
import com.samhalperin.cooperhewitt.ui.MainActivity;
import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.retrofit.pojo.searchobjects.SearchObject;

import java.util.List;

/**
 * Created by sqh on 9/30/15.
 */
public class MainGridView extends GridView {
    private MyGridViewAdapter mGridViewAdapter;
    private boolean mInitted = false;
    private MainActivity mActivity;

    public MainGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mActivity = (MainActivity)context; // Refactor?
        init();
    }

    public void onData(int page, int nPerPage, List<SearchObject> data) {
        if (data.size() != 0) {
          getLoadingView().setVisibility(View.GONE);
        }
        getAdapter().addItems(data);
    }

    public MyGridViewAdapter getAdapter() {
        if (!mInitted) {
            Log.e("", "You need to init the MainGridView before calling get adapter");
            return null;
        }

        if (mGridViewAdapter == null) {
            mGridViewAdapter = new MyGridViewAdapter(mActivity);// this typecast is lame;
        }

        return mGridViewAdapter;
    }


    private void init() {
        mInitted = true;
        setAdapter(getAdapter());
        setOnScrollListener(endlessScrollListener);
        setOnItemClickListener(onItemClickListener);

    }

    EndlessScrollListener endlessScrollListener =
        new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your AdapterView
                new SearchTask(mActivity, MainGridView.this).execute(page, MyApplication.DEFAULT_PER_PAGE,
                        mActivity.getCurrentPeriod());
                // or customLoadMoreDataFromApi(totalItemsCount);
                return true; // ONLY if more data is actually being loaded; false otherwise.
            }
        };

    public void clear() {
        getAdapter().clear();
    }


    OnItemClickListener onItemClickListener = new GridView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SearchObject item = getAdapter().getItem(position);
            Controller.startItemDetail(getContext(), item.getId());
        }
    };

    public View getLoadingView() {
        return ((View)getParent()).findViewById(R.id.main_grid_view_loading_view);
    }
}