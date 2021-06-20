package com.android.locbookapp.ui.cab;

/**
 * Created by Rachana on 3/23/2017.
 */

public class TaxiFare {

    private String kilometer;
    private String dayFare;
    private String nightFare;

    public TaxiFare(String kilometer, String dayFare, String nightFare) {
        this.kilometer = kilometer;
        this.dayFare = dayFare;
        this.nightFare = nightFare;
    }

    public String getKilometer() {
        return kilometer;
    }

    private void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public String getDayFare() {
        return dayFare;
    }

    private void setDayFare(String dayFare) {
        this.dayFare = dayFare;
    }

    public String getNightFare() {
        return nightFare;
    }

    private void setNightFare(String nightFare) {
        this.nightFare = nightFare;
    }


}
