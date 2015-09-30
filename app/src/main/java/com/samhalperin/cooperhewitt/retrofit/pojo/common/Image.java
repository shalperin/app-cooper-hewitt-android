package com.samhalperin.cooperhewitt.retrofit.pojo.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sqh on 9/29/15.
 */
public class Image {
    @SerializedName("b")
    @Expose
    private ImageData b;

    @SerializedName("z")
    @Expose
    private ImageData z;

    @SerializedName("n")
    @Expose
    private ImageData n;

    @SerializedName("d")
    @Expose
    private ImageData d;

    @SerializedName("sq")
    @Expose
    private ImageData sq;


    public ImageData getB() {
        return b;
    }

    public ImageData getZ() {
        return z;
    }

    public ImageData getN() {
        return n;
    }

    public ImageData getD() {
        return d;
    }

    public ImageData getSq() {
        return sq;
    }

    public void setB(ImageData b) {
        this.b = b;
    }

    public void setZ(ImageData z) {
        this.z = z;
    }

    public void setN(ImageData n) {
        this.n = n;
    }

    public void setD(ImageData d) {
        this.d = d;
    }

    public void setSq(ImageData sq) {
        this.sq = sq;
    }
}
