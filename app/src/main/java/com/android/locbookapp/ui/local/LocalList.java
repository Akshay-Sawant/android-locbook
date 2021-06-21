package com.android.locbookapp.ui.local;

/**
 * Created by Rachana on 3/29/2017.
 */

public class LocalList {
    private String localStationName;
    private String localRoute;

    public LocalList(String localStationName, String localRoute) {
        this.setLocalStationName(localStationName);
        this.setLocalRoute(localRoute);
    }

    public String getLocalStationName() {
        return localStationName;
    }

    public void setLocalStationName(String localStationName) {
        this.localStationName = localStationName;
    }

    public String getLocalRoute() {
        return localRoute;
    }

    public void setLocalRoute(String localRoute) {
        this.localRoute = localRoute;
    }
}
