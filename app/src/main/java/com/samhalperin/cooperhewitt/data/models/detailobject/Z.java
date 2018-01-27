package com.samhalperin.cooperhewitt.data.models.detailobject;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Z {

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
    private String isPrimary;
    @SerializedName("image_id")
    @Expose
    private String imageId;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The isPrimary
     */
    public String getIsPrimary() {
        return isPrimary;
    }

    /**
     *
     * @param isPrimary
     * The is_primary
     */
    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    /**
     *
     * @return
     * The imageId
     */
    public String getImageId() {
        return imageId;
    }

    /**
     *
     * @param imageId
     * The image_id
     */
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

}
