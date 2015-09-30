package com.samhalperin.cooperhewitt.ui.maingridview;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.samhalperin.cooperhewitt.Controller;
import com.samhalperin.cooperhewitt.retrofit.SearchTask;
import com.samhalperin.cooperhewitt.ui.MainActivity;
import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.retrofit.pojo.searchobjects.SearchObject;

import java.util.List;

/**
 * Created by sqh on 9/30/15.
 */
public class MainGridView {
    final MainActivity mContext;
    private MyGridViewAdapter mGridViewAdapter;
    private EndlessScrollListener mEndlessScrollListener;
    private GridView mView;
    private GridView.OnItemClickListener mOnItemClickListener;
    private boolean mInitted = false;

    public MainGridView(MainActivity context, View view) {
        mContext = context;
        mView = (GridView)view;
        init();
    }

    public void onData(int page, int nPerPage, List<SearchObject> data) {
        getAdapter().addItems(data);
    }

    public MyGridViewAdapter getAdapter() {
        if (!mInitted) {
            Log.e("", "You need to init the MainGridView before calling get adapter");
            return null;
        }

        if (mGridViewAdapter == null) {
            mGridViewAdapter = new MyGridViewAdapter(mContext);
        }
        return mGridViewAdapter;
    }


    private void init() {
        mInitted = true;
        mView.setAdapter(getAdapter());
        mView.setOnScrollListener(getEndlessScrollListener());
        mView.setOnItemClickListener(getOnItemClickListener());

    }


    private EndlessScrollListener getEndlessScrollListener() {
        if (mEndlessScrollListener == null) {
            mEndlessScrollListener = new EndlessScrollListener() {
                @Override
                public boolean onLoadMore(int page, int totalItemsCount) {
                    // Triggered only when new data needs to be appended to the list
                    // Add whatever code is needed to append new items to your AdapterView
                    new SearchTask(mContext, MainGridView.this).execute(page, MyApplication.DEFAULT_PER_PAGE,
                            mContext.getCurrentPeriod());
                    // or customLoadMoreDataFromApi(totalItemsCount);
                    return true; // ONLY if more data is actually being loaded; false otherwise.
                }
            };
        }
        return mEndlessScrollListener;
    }

    private GridView.OnItemClickListener getOnItemClickListener() {
        if (mOnItemClickListener == null) {
            mOnItemClickListener = new GridView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    SearchObject item = getAdapter().getItem(position);
                    Controller.startItemDetail(mContext, item.getId());
                }
            };
        }
        return mOnItemClickListener;
    }

    public void clear() {
        getAdapter().clear();
    }
}