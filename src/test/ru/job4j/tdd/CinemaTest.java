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
        Account account = new AccountCinema(100);
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
    @Test
    public void whenPutToAccount() {
        Account account = new AccountCinema(0);
        int balance = account.put(100);
        int expected = 100;
        assertEquals(expected, balance);
    }

    @Ignore
    @Test
    public void whenWithdrawFromAccount() {
        Account account = new AccountCinema(100);
        int balance = account.withdraw(50);
        int expected = 50;
        assertEquals(expected, balance);
    }

    @Ignore
    @Test
    public void whenEnjoySession() {
        Ticket3D ticket3D = new Ticket3D();
        Session session = new Session3D();
        session.enjoy(ticket3D);
        int ticket = ticket3D.use();
        int expected = 0;
        assertEquals(expected, ticket);
    }

    @Ignore
    @Test
    public void obtainTicketFromAnywhere() {
        Ticket3D ticket3D = new Ticket3D();
        int ticketsWere = 2;
        int ticketsNow = ticket3D.obtain();
        int expected = 3;
        assertEquals(expected, ticketsNow);
    }

    @Ignore
    @Test
    public void whenJustUseTicket() {
        Ticket3D ticket3D = new Ticket3D();
        Session3D session3D = new Session3D();
        int ticketsWere = 1;
        int ticketsNow = ticket3D.use();
        session3D.enjoy(ticket3D);
        int expected = 0;
        assertEquals(expected, ticketsNow);
    }

    @Ignore
    @Test
    public void sellTicket() {
        Ticket3D ticket3D = new Ticket3D();
        int ticketsWere = 2;
        int ticketsNow = ticket3D.sell();
        int expected = 1;
        assertEquals(expected, ticketsNow);
    }
}