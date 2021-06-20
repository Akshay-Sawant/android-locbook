package com.android.locbookapp.ui.bus;

/**
 * Created by Aradhana on 28-03-2017.
 */

public class BusNumber {

    String busNumber;
    String busSource;
    String busDestination;
    String busArea;
    String busStopNumbers;

    public BusNumber(String busNumber, String busSource, String busDestination, String busArea, String busStopNumbers) {
        this.setBusNumber(busNumber);
        this.setBusSource(busSource);
        this.setBusDestination(busDestination);
        this.setBusArea(busArea);
        this.setBusStopNumbers(busStopNumbers);
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    public String getBusArea() {
        return busArea;
    }

    public void setBusArea(String busArea) {
        this.busArea = busArea;
    }

    public String getBusStopNumbers() {
        return busStopNumbers;
    }

    public void setBusStopNumbers(String busStopNumbers) {
        this.busStopNumbers = busStopNumbers;
    }
}
