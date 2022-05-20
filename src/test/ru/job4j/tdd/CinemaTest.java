package ru.job4j.tdd;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketInvalidSeat() {
    Account account = new AccountCinema();
    Cinema3D cinema3D = new Cinema3D();
    Calendar date = Calendar.getInstance();
    date.set(2020, 10, 10, 23, 00);
    cinema3D.buy(account, -1, 1000, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketInvalidDate() {
    Account account = new AccountCinema();
    Cinema3D cinema3D = new Cinema3D();
    Calendar date = Calendar.getInstance();
    date.set(2020, Calendar.FEBRUARY, 30, 21, 30);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketSeatAlreadyPurchased() {
    Account account = new AccountCinema();
    Cinema3D cinema3D = new Cinema3D();
    Calendar date = Calendar.getInstance();
    date.set(2020, 10, 10, 23, 00);
    cinema3D.buy(account, 4, 10, date);
    cinema3D.buy(account, 4, 10, date);
    }
}