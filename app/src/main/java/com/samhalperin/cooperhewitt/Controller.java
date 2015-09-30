package com.samhalperin.cooperhewitt;

import android.content.Context;
import android.content.Intent;

import com.samhalperin.cooperhewitt.ui.DetailActivity;

/**
 * Created by sqh on 9/30/15.
 */
public class Controller {

    public static void startItemDetail(Context context, String itemId) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(MyApplication.EXTRA_ITEM_ID_KEY, itemId);
        context.startActivity(i);
    }



}
