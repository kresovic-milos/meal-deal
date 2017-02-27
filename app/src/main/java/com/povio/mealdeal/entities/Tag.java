package com.povio.mealdeal.entities;

import org.parceler.Parcel;

/**
 * Created by Kresa on 2/16/17.
 */

@Parcel(Parcel.Serialization.BEAN)
public class Tag {

    private String uid;
    private String name;
    private int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
