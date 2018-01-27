package com.samhalperin.cooperhewitt.application;

import android.app.Application;

import com.samhalperin.cooperhewitt.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sqh on 9/29/15.
 */
public class CooperHewittApplication extends Application {

    /*
    The root of the Cooper Hewitt API
     */
    public static final String API_ROOT = "https://api.collection.cooperhewitt.org/rest/";

    /*
    The app uses a paging interface of images, this is the default n per page.
     */
    public static final int DEFAULT_PER_PAGE = 40;


    /* The bundle extra for making the link between the home page and a detail page */
    public static final String EXTRA_ITEM_ID_KEY = "item_id";

    /* A config option for endless scroll. */
    public static final int EndlessScrollVisibilityThreshold = 15;

    /* If this is hosted in a public github repo it is better
       to gitignore the API key.  For demo purposes comment out and
       return here.
    */
    public String getAccessToken() {
        return getResources().getString(R.string.api_key);
    }

}
