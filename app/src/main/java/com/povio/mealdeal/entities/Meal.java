package com.povio.mealdeal.entities;

import android.nfc.Tag;

import java.util.List;

/**
 * Created by Kresa on 2/16/17.
 */

public class Meal extends BaseEntity {

    private String name;
    private String description;
    private String photoUrl;
    private List<Tag> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
