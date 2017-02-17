package com.povio.mealdeal.model;

/**
 * Created by Kresa on 2/16/17.
 */

public class Restaurant {

    private String uid;
    private String name;
    private ContactInfo contactInfo;

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
}
