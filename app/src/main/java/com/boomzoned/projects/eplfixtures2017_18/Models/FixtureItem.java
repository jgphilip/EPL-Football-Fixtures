package com.boomzoned.projects.eplfixtures2017_18.Models;

import java.util.Date;

/**
 * Created by jeevan on 8/10/17.
 */

public class FixtureItem {

    public String getmOpposition() {
        return mOpposition;
    }

    public void setmOpposition(String mOpposition) {
        this.mOpposition = mOpposition;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    String mOpposition;
    Date mDate;

    public String getmHomeAway() {
        return mHomeAway;
    }

    public void setmHomeAway(String mHomeAway) {
        this.mHomeAway = mHomeAway;
    }

    String mHomeAway;
}
