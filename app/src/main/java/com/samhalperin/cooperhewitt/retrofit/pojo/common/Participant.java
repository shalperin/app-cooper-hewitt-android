package com.samhalperin.cooperhewitt.retrofit.pojo.common;

/**
 * Created by sqh on 9/29/15.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Participant {

    @SerializedName("person_id")
    @Expose
    private String personId;
    @SerializedName("role_id")
    @Expose
    private String roleId;
    @SerializedName("person_name")
    @Expose
    private String personName;
    @SerializedName("person_date")
    @Expose
    private String personDate;
    @SerializedName("role_name")
    @Expose
    private String roleName;
    @SerializedName("role_display_name")
    @Expose
    private String roleDisplayName;
    @SerializedName("person_url")
    @Expose
    private String personUrl;
    @SerializedName("role_url")
    @Expose
    private String roleUrl;

    /**
     *
     * @return
     * The personId
     */
    public String getPersonId() {
        return personId;
    }

    /**
     *
     * @param personId
     * The person_id
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     *
     * @return
     * The roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     *
     * @param roleId
     * The role_id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     *
     * @return
     * The personName
     */
    public String getPersonName() {
        return personName;
    }

    /**
     *
     * @param personName
     * The person_name
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     *
     * @return
     * The personDate
     */
    public String getPersonDate() {
        return personDate;
    }

    /**
     *
     * @param personDate
     * The person_date
     */
    public void setPersonDate(String personDate) {
        this.personDate = personDate;
    }

    /**
     *
     * @return
     * The roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @param roleName
     * The role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     *
     * @return
     * The roleDisplayName
     */
    public String getRoleDisplayName() {
        return roleDisplayName;
    }

    /**
     *
     * @param roleDisplayName
     * The role_display_name
     */
    public void setRoleDisplayName(String roleDisplayName) {
        this.roleDisplayName = roleDisplayName;
    }

    /**
     *
     * @return
     * The personUrl
     */
    public String getPersonUrl() {
        return personUrl;
    }

    /**
     *
     * @param personUrl
     * The person_url
     */
    public void setPersonUrl(String personUrl) {
        this.personUrl = personUrl;
    }

    /**
     *
     * @return
     * The roleUrl
     */
    public String getRoleUrl() {
        return roleUrl;
    }

    /**
     *
     * @param roleUrl
     * The role_url
     */
    public void setRoleUrl(String roleUrl) {
        this.roleUrl = roleUrl;
    }

}