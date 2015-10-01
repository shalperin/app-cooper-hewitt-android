package com.samhalperin.cooperhewitt;

import android.content.Context;
import android.content.Intent;

import com.samhalperin.cooperhewitt.ui.AboutActivity;
import com.samhalperin.cooperhewitt.ui.DetailActivity;

/**
 * Created by sqh on 9/30/15.
 */
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
        i.putExtra(MyApplication.EXTRA_ITEM_ID_KEY, itemId);
        context.startActivity(i);
    }



}
