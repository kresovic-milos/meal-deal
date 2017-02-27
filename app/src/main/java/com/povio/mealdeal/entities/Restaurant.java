package com.povio.mealdeal.entities;

import org.parceler.Parcel;

import java.util.Date;

/**
 * Created by Kresa on 2/16/17.
 */

@Parcel(Parcel.Serialization.BEAN)
public class Restaurant {

    private String uid;
    private String name;
    private ContactInfo contactInfo;
    private Date openAt;
    private Date closeAt;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Date getOpenAt() {
        return openAt;
    }

    public void setOpenAt(Date openAt) {
        this.openAt = openAt;
    }

    public Date getCloseAt() {
        return closeAt;
    }

    public void setCloseAt(Date closeAt) {
        this.closeAt = closeAt;
    }
}
