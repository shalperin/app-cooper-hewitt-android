package com.samhalperin.cooperhewitt;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sqh on 9/29/15.
 */
public class MyApplication extends Application {

    public static final String API_ROOT = "https://api.collection.cooperhewitt.org/rest/";
    public static final int DEFAULT_PER_PAGE = 20;
    public static final String EXTRA_ITEM_ID_KEY = "item_id";

    public String getAccessToken() {
        return getResources().getString(R.string.api_key);
    }

}
