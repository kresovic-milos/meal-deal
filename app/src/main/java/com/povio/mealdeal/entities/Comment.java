package com.povio.mealdeal.entities;

import org.parceler.Parcel;

import java.util.Date;

/**
 * Created by Kresa on 2/21/17.
 */

@Parcel(Parcel.Serialization.BEAN)
public class Comment {

    private String uid;
    private Date createdAt;
    private String messageText;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
