package com.samhalperin.cooperhewitt.retrofit.pojo.detailobject;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DetailObject {

    @SerializedName("object")
    @Expose
    private Object object;
    @SerializedName("stat")
    @Expose
    private String stat;

    /**
     *
     * @return
     * The object
     */
    public Object getObject() {
        return object;
    }

    /**
     *
     * @param object
     * The object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     *
     * @return
     * The stat
     */
    public String getStat() {
        return stat;
    }

    /**
     *
     * @param stat
     * The stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

}