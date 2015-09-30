package com.samhalperin.cooperhewitt.retrofit.pojo.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sqh on 9/30/15.
 */
public class ImageData {
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("width")
    @Expose
    private Integer width;

    @SerializedName("height")
    @Expose
    private Integer height;

    @SerializedName("is_primary")
    @Expose
    private Integer isPrimary;

    @SerializedName("image_id")
    @Expose
    private Integer imageId;

    public String getUrl() {
        return url;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getIsPrimary() {
        return isPrimary;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
