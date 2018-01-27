package com.samhalperin.cooperhewitt.data.models.common;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DimensionsRaw {

    @SerializedName("height")
    @Expose
    private List<String> height = new ArrayList<String>();
    @SerializedName("width")
    @Expose
    private List<String> width = new ArrayList<String>();

    /**
     *
     * @return
     * The height
     */
    public List<String> getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(List<String> height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The width
     */
    public List<String> getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(List<String> width) {
        this.width = width;
    }

}
