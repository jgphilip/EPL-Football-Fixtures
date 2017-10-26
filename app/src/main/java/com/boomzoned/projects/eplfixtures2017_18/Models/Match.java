package com.boomzoned.projects.eplfixtures2017_18.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by jeevan on 8/9/17.
 */

public class Match {
    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Team getmTeam1() {
        return mTeam1;
    }

    public void setmTeam1(Team mTeam1) {
        this.mTeam1 = mTeam1;
    }

    public Team getmTeam2() {
        return mTeam2;
    }

    public void setmTeam2(Team mTeam2) {
        this.mTeam2 = mTeam2;
    }

    public String getmScore1() {
        return mScore1;
    }

    public void setmScore1(String mScore1) {
        this.mScore1 = mScore1;
    }

    public String getmScore2() {
        return mScore2;
    }

    public void setmScore2(String mScore2) {
        this.mScore2 = mScore2;
    }

    @SerializedName("date")
    Date mDate;

    @SerializedName("team1")
    Team mTeam1;

    @SerializedName("team2")
    Team mTeam2;

    @SerializedName("score1")
    String mScore1;

    @SerializedName("score2")
    String mScore2;
}
