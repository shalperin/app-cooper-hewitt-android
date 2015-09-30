package com.samhalperin.cooperhewitt.retrofit.pojo.detailobject;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.samhalperin.cooperhewitt.retrofit.pojo.common.DimensionsRaw;
import com.samhalperin.cooperhewitt.retrofit.pojo.common.Image;
import com.samhalperin.cooperhewitt.retrofit.pojo.common.Participant;

@Generated("org.jsonschema2pojo")
public class Object {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tms:id")
    @Expose
    private String tmsId;
    @SerializedName("accession_number")
    @Expose
    private String accessionNumber;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_raw")
    @Expose
    private String titleRaw;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("department_id")
    @Expose
    private String departmentId;
    @SerializedName("period_id")
    @Expose
    private String periodId;
    @SerializedName("media_id")
    @Expose
    private String mediaId;
    @SerializedName("type_id")
    @Expose
    private String typeId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("year_start")
    @Expose
    private Integer yearStart;
    @SerializedName("year_end")
    @Expose
    private Integer yearEnd;
    @SerializedName("year_acquired")
    @Expose
    private String yearAcquired;
    @SerializedName("decade")
    @Expose
    private String decade;
    @SerializedName("woe:country_id")
    @Expose
    private String woeCountryId;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("markings")
    @Expose
    private java.lang.Object markings;
    @SerializedName("signed")
    @Expose
    private java.lang.Object signed;
    @SerializedName("inscribed")
    @Expose
    private java.lang.Object inscribed;
    @SerializedName("provenance")
    @Expose
    private String provenance;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;
    @SerializedName("dimensions_raw")
    @Expose
    private DimensionsRaw dimensionsRaw;
    @SerializedName("creditline")
    @Expose
    private String creditline;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("justification")
    @Expose
    private java.lang.Object justification;
    @SerializedName("gallery_text")
    @Expose
    private java.lang.Object galleryText;
    @SerializedName("label_text")
    @Expose
    private java.lang.Object labelText;
    @SerializedName("videos")
    @Expose
    private java.lang.Object videos;
    @SerializedName("on_display")
    @Expose
    private java.lang.Object onDisplay;
    @SerializedName("woe:country")
    @Expose
    private String woeCountry;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = new ArrayList<Participant>();
    @SerializedName("woe:country_name")
    @Expose
    private String woeCountryName;
    @SerializedName("is_loan_object")
    @Expose
    private Integer isLoanObject;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The tmsId
     */
    public String getTmsId() {
        return tmsId;
    }

    /**
     *
     * @param tmsId
     * The tms:id
     */
    public void setTmsId(String tmsId) {
        this.tmsId = tmsId;
    }

    /**
     *
     * @return
     * The accessionNumber
     */
    public String getAccessionNumber() {
        return accessionNumber;
    }

    /**
     *
     * @param accessionNumber
     * The accession_number
     */
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The titleRaw
     */
    public String getTitleRaw() {
        return titleRaw;
    }

    /**
     *
     * @param titleRaw
     * The title_raw
     */
    public void setTitleRaw(String titleRaw) {
        this.titleRaw = titleRaw;
    }

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
     * The departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     *
     * @param departmentId
     * The department_id
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     *
     * @return
     * The periodId
     */
    public String getPeriodId() {
        return periodId;
    }

    /**
     *
     * @param periodId
     * The period_id
     */
    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    /**
     *
     * @return
     * The mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     *
     * @param mediaId
     * The media_id
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     *
     * @return
     * The typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     *
     * @param typeId
     * The type_id
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The yearStart
     */
    public Integer getYearStart() {
        return yearStart;
    }

    /**
     *
     * @param yearStart
     * The year_start
     */
    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    /**
     *
     * @return
     * The yearEnd
     */
    public Integer getYearEnd() {
        return yearEnd;
    }

    /**
     *
     * @param yearEnd
     * The year_end
     */
    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
    }

    /**
     *
     * @return
     * The yearAcquired
     */
    public String getYearAcquired() {
        return yearAcquired;
    }

    /**
     *
     * @param yearAcquired
     * The year_acquired
     */
    public void setYearAcquired(String yearAcquired) {
        this.yearAcquired = yearAcquired;
    }

    /**
     *
     * @return
     * The decade
     */
    public String getDecade() {
        return decade;
    }

    /**
     *
     * @param decade
     * The decade
     */
    public void setDecade(String decade) {
        this.decade = decade;
    }

    /**
     *
     * @return
     * The woeCountryId
     */
    public String getWoeCountryId() {
        return woeCountryId;
    }

    /**
     *
     * @param woeCountryId
     * The woe:country_id
     */
    public void setWoeCountryId(String woeCountryId) {
        this.woeCountryId = woeCountryId;
    }

    /**
     *
     * @return
     * The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     *
     * @param medium
     * The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     *
     * @return
     * The markings
     */
    public java.lang.Object getMarkings() {
        return markings;
    }

    /**
     *
     * @param markings
     * The markings
     */
    public void setMarkings(java.lang.Object markings) {
        this.markings = markings;
    }

    /**
     *
     * @return
     * The signed
     */
    public java.lang.Object getSigned() {
        return signed;
    }

    /**
     *
     * @param signed
     * The signed
     */
    public void setSigned(java.lang.Object signed) {
        this.signed = signed;
    }

    /**
     *
     * @return
     * The inscribed
     */
    public java.lang.Object getInscribed() {
        return inscribed;
    }

    /**
     *
     * @param inscribed
     * The inscribed
     */
    public void setInscribed(java.lang.Object inscribed) {
        this.inscribed = inscribed;
    }

    /**
     *
     * @return
     * The provenance
     */
    public String getProvenance() {
        return provenance;
    }

    /**
     *
     * @param provenance
     * The provenance
     */
    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    /**
     *
     * @return
     * The dimensions
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     *
     * @param dimensions
     * The dimensions
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     *
     * @return
     * The dimensionsRaw
     */
    public DimensionsRaw getDimensionsRaw() {
        return dimensionsRaw;
    }

    /**
     *
     * @param dimensionsRaw
     * The dimensions_raw
     */
    public void setDimensionsRaw(DimensionsRaw dimensionsRaw) {
        this.dimensionsRaw = dimensionsRaw;
    }

    /**
     *
     * @return
     * The creditline
     */
    public String getCreditline() {
        return creditline;
    }

    /**
     *
     * @param creditline
     * The creditline
     */
    public void setCreditline(String creditline) {
        this.creditline = creditline;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The justification
     */
    public java.lang.Object getJustification() {
        return justification;
    }

    /**
     *
     * @param justification
     * The justification
     */
    public void setJustification(java.lang.Object justification) {
        this.justification = justification;
    }

    /**
     *
     * @return
     * The galleryText
     */
    public java.lang.Object getGalleryText() {
        return galleryText;
    }

    /**
     *
     * @param galleryText
     * The gallery_text
     */
    public void setGalleryText(java.lang.Object galleryText) {
        this.galleryText = galleryText;
    }

    /**
     *
     * @return
     * The labelText
     */
    public java.lang.Object getLabelText() {
        return labelText;
    }

    /**
     *
     * @param labelText
     * The label_text
     */
    public void setLabelText(java.lang.Object labelText) {
        this.labelText = labelText;
    }

    /**
     *
     * @return
     * The videos
     */
    public java.lang.Object getVideos() {
        return videos;
    }

    /**
     *
     * @param videos
     * The videos
     */
    public void setVideos(java.lang.Object videos) {
        this.videos = videos;
    }

    /**
     *
     * @return
     * The onDisplay
     */
    public java.lang.Object getOnDisplay() {
        return onDisplay;
    }

    /**
     *
     * @param onDisplay
     * The on_display
     */
    public void setOnDisplay(java.lang.Object onDisplay) {
        this.onDisplay = onDisplay;
    }

    /**
     *
     * @return
     * The woeCountry
     */
    public String getWoeCountry() {
        return woeCountry;
    }

    /**
     *
     * @param woeCountry
     * The woe:country
     */
    public void setWoeCountry(String woeCountry) {
        this.woeCountry = woeCountry;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     *
     * @return
     * The participants
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     *
     * @param participants
     * The participants
     */
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    /**
     *
     * @return
     * The woeCountryName
     */
    public String getWoeCountryName() {
        return woeCountryName;
    }

    /**
     *
     * @param woeCountryName
     * The woe:country_name
     */
    public void setWoeCountryName(String woeCountryName) {
        this.woeCountryName = woeCountryName;
    }

    /**
     *
     * @return
     * The isLoanObject
     */
    public Integer getIsLoanObject() {
        return isLoanObject;
    }

    /**
     *
     * @param isLoanObject
     * The is_loan_object
     */
    public void setIsLoanObject(Integer isLoanObject) {
        this.isLoanObject = isLoanObject;
    }

}