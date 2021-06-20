package com.android.locbookapp.ui.mono;

/**
 * Created by Rachana on 3/24/2017.
 */

public class MonoTimeTable {

    private String monoTime;
    private String monoRoute;
    private String monoMode;
    private String monoDestination;

    public MonoTimeTable(String monoTime, String monoRoute, String monoMode, String monoDestination) {
        this.setMonoTime(monoTime);
        this.setMonoRoute(monoRoute);
        this.setMonoMode(monoMode);
        this.setMonoDestination(monoDestination);
    }

    public String getMonoTime() {
        return monoTime;
    }

    public void setMonoTime(String monoTime) {
        this.monoTime = monoTime;
    }

    public String getMonoRoute() {
        return monoRoute;
    }

    public void setMonoRoute(String monoRoute) {
        this.monoRoute = monoRoute;
    }

    public String getMonoMode() {
        return monoMode;
    }

    public void setMonoMode(String monoMode) {
        this.monoMode = monoMode;
    }

    public String getMonoDestination() {
        return monoDestination;
    }

    public void setMonoDestination(String monoDestination) {
        this.monoDestination = monoDestination;
    }
}