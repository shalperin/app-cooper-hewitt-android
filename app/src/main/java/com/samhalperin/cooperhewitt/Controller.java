package com.samhalperin.cooperhewitt;

import android.content.Context;
import android.content.Intent;

import com.samhalperin.cooperhewitt.aboutscreen.AboutActivity;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.detailscreen.DetailActivity;

/**
* The purpose of this class is a central place for route switching when navigating
 * between activities.
 * */
public class Controller {

    public static final int MODE_ABOUT = 1;

    public static void switchMode(Context context, int mode) {
        switch(mode) {
            case(MODE_ABOUT):
                context.startActivity(new Intent(context, AboutActivity.class));
                break;
        }
    }

    public static void startItemDetail(Context context, String itemId) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(CooperHewittApplication.EXTRA_ITEM_ID_KEY, itemId);
        context.startActivity(i);
    }

    public static void share(Context context, String text){


    }



}
