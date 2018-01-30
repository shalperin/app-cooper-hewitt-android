package com.samhalperin.cooperhewitt.application;

import android.app.Application;
import android.os.StrictMode;

import com.samhalperin.cooperhewitt.BuildConfig;
import com.samhalperin.cooperhewitt.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CooperHewittApplication extends Application {

    /*
    The root of the Cooper Hewitt API
     */
    public static final String API_ROOT = "https://api.collection.cooperhewitt.org";

    /*
    The app uses a paging interface of images, this is the default n per page.
     */
    public static final int DEFAULT_PER_PAGE = 40;

    /* In the main RV, the number of items left after which a scroll is triggered. */
    public static final int EndlessScrollVisibilityThreshold = 10;

    /* The bundle extra for making the link between the home page and a detail page */
    public static final String EXTRA_ITEM_ID_KEY = "item_id";



    /* If this is hosted in a public github repo it is better
       to gitignore the API key.  For demo purposes comment out and
       return here.
    */
    public String getAccessToken() {
        return getResources().getString(R.string.api_key);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
