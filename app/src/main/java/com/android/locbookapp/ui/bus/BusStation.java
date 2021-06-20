package com.android.locbookapp.ui.bus;

/**
 * Created by Rachana on 5/2/2017.
 */

public class BusStation {

    String busStopName;

    public BusStation(String busStopName) {
        this.setBusStopName(busStopName);
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

}
