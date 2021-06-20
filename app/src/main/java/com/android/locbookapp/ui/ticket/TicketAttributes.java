package com.android.locbookapp.ui.ticket;

/**
 * Created by Rachana on 3/31/2017.
 */

public class TicketAttributes {
    private String ticketFare, currentDate, mobileNumber, source, destination, adultNumber, childNumber, distance, ticketClass, bookDateTime;

    public TicketAttributes(String ticketFare, String currentDate, String mobileNumber, String source, String destination, String adultNumber,
                            String childNumber, String distance, String ticketClass, String bookDateTime) {
        this.setTicketFare(ticketFare);
        this.setCurrentDate(currentDate);
        this.setMobileNumber(mobileNumber);
        this.setSource(source);
        this.setDestination(destination);
        this.setAdultNumber(adultNumber);
        this.setChildNumber(childNumber);
        this.setDistance(distance);
        this.setTicketClass(ticketClass);
        this.setBookDateTime(bookDateTime);
    }

    public String getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(String ticketFare) {
        this.ticketFare = ticketFare;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(String adultNumber) {
        this.adultNumber = adultNumber;
    }

    public String getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(String childNumber) {
        this.childNumber = childNumber;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getBookDateTime() {
        return bookDateTime;
    }

    public void setBookDateTime(String bookDateTime) {
        this.bookDateTime = bookDateTime;
    }
}
