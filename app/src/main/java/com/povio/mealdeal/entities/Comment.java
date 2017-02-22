package com.povio.mealdeal.entities;

import java.util.Date;

/**
 * Created by Kresa on 2/21/17.
 */

public class Comment extends BaseEntity {

    private Date createdAt;
    private String messageText;

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
