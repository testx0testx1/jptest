package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(10,43,12)));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(11,43,12)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith3DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(10,43,12)));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith2DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(10,43,12)));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWith1DollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(10,43,12)));
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWithoutDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(10,43,12)));
        assertEquals(12.5, spiderMan.calculateTicketPrice(showing));
    }
}
