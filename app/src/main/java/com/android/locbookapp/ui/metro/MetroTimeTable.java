package com.android.locbookapp.ui.metro;

/**
 * Created by Rachana on 3/24/2017.
 */

public class MetroTimeTable {

    private String metroTime, metroRoute;

    public MetroTimeTable(String metroTime, String metroRoute) {
        this.setMetroTime(metroTime);
        this.setMetroRoute(metroRoute);
    }

    public String getMetroTime() {
        return metroTime;
    }

    public void setMetroTime(String metroTime) {
        this.metroTime = metroTime;
    }

    public String getMetroRoute() {
        return metroRoute;
    }

    public void setMetroRoute(String metroRoute) {
        this.metroRoute = metroRoute;
    }
}
