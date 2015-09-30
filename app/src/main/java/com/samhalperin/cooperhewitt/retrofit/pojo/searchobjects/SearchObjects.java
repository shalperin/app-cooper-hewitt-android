package com.samhalperin.cooperhewitt.retrofit.pojo.searchobjects;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sqh on 9/29/15.
 */
@Generated("org.jsonschema2pojo")
public class SearchObjects {

    @SerializedName("objects")
    @Expose
    private List<SearchObject> objects = new ArrayList<SearchObject>();

    /**
     *
     * @return
     * The objects
     */
    public List<SearchObject> getObjects() {
        return objects;
    }

    /**
     *
     * @param objects
     * The objects
     */
    public void setObjects(List<SearchObject> objects) {
        this.objects = objects;
    }

}

