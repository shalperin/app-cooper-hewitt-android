package com.samhalperin.cooperhewitt.ui.maingridview;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.samhalperin.cooperhewitt.ui.MainActivity;
import com.samhalperin.cooperhewitt.retrofit.pojo.common.Image;
import com.samhalperin.cooperhewitt.retrofit.pojo.searchobjects.SearchObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sqh on 9/29/15.
 */

public class MyGridViewAdapter extends BaseAdapter {

    private List<SearchObject> mData;
    private LayoutInflater mInflater;
    private MainActivity mContext;

    public MyGridViewAdapter(MainActivity context) {
        mData = new ArrayList<SearchObject>();
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public SearchObject getItem(int position) {
        return mData.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0; //unimpl
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridImageView giv;

        if (convertView == null) {
            giv = new GridImageView(mContext);
        } else {
            giv = (GridImageView)convertView;
        }

        List<Image> images = mData.get(position).getImages();
        if (images.size() != 0) {
            String sqUrl = mData.get(position).getImages().get(0).getSq().getUrl();
            Picasso
                    .with(mContext)
                    .load(sqUrl)
                    .fit()
                    .into(giv);
        }


        return giv;
    }

    public void addItems(List<SearchObject> items) {
        mData.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }
}


