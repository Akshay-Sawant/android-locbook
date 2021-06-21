package com.android.locbookapp.ui.history;

/**
 * Created by Rachana on 3/31/2017.
 */

public class TransactionClassAttributes {

    private String randomTransactionID, transactionDateTime, ticketFare;

    public TransactionClassAttributes(String randomTransactionID, String transactionDateTime, String ticketFare) {
        this.setRandomTransactionID(randomTransactionID);
        this.setTransactionDateTime(transactionDateTime);
        this.setTicketFare(ticketFare);
    }

    public String getRandomTransactionID() {
        return randomTransactionID;
    }

    public void setRandomTransactionID(String randomTransactionID) {
        this.randomTransactionID = randomTransactionID;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(String ticketFare) {
        this.ticketFare = ticketFare;
    }
}
