package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        if (audienceCount > showing.getAvailableSeats()) {
            throw new IllegalArgumentException("can not over book from capacity");
        }
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        showing.setAvailableSeats(showing.getAvailableSeats() - audienceCount);
    }

    public double totalFee() {
        return showing.getMovieFee() * audienceCount;
    }
}