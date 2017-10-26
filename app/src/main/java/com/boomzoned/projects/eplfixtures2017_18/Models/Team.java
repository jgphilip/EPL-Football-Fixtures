package com.boomzoned.projects.eplfixtures2017_18.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jeevan on 8/9/17.
 */

public class Team {
    @SerializedName("key")
    String mKey;

    @SerializedName("name")
    String mName;

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    @SerializedName("code")
    String mCode;
}
