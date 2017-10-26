package com.boomzoned.projects.eplfixtures2017_18.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jeevan on 8/9/17.
 */

public class Round {

    @SerializedName("name")
    String mMatchday;

    public String getmMatchday() {
        return mMatchday;
    }

    public void setmMatchday(String mMatchday) {
        this.mMatchday = mMatchday;
    }

    public List<Match> getmMatches() {
        return mMatches;
    }

    public void setmMatches(List<Match> mMatches) {
        this.mMatches = mMatches;
    }

    @SerializedName("matches")

    List<Match> mMatches;
}
