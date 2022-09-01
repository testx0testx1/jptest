package com.jpmc.theater;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Showing {
    public static int DEFAULT_CAPACITY = 100;
    private int capacity;
    private int availableSeats;
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime, int capacity) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this(movie, sequenceOfTheDay, showStartTime, Showing.DEFAULT_CAPACITY);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public String toJSONString() {
        return "{sequenceOfTheDay: " + getSequenceOfTheDay() + ", startTime: " + getStartTime() + ", movieTitle: " + getMovie().getTitle() + ", movieRunningTime: " + humanReadableFormat(getMovie().getRunningTime()) + ", movieFee: $" + getMovieFee() + "}";
    }

    public String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }
}
