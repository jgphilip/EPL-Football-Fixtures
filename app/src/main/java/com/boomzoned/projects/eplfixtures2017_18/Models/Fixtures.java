package com.boomzoned.projects.eplfixtures2017_18.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jeevan on 8/9/17.
 */

public class Fixtures {

    @SerializedName("name")
    String mSeason;

    public List<Round> getmRounds() {
        return mRounds;
    }

    public void setmRounds(List<Round> mRounds) {
        this.mRounds = mRounds;
    }

    @SerializedName("rounds")

    List<Round> mRounds;
}
