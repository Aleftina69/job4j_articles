package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.List;


public class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnTakenSeatThenGetException() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        cinema.buy(account1, 1, 1, date);
        assertThatThrownBy(() -> cinema.buy(account2, 1, 1, date))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void whenFindSessionByConditionThenGetMatchingSessions() {
        Cinema cinema = new Cinema3D();
        Session session1 = new Session3D();
        Session session2 = new Session3D();
        cinema.add(session1);
        cinema.add(session2);
        List<Session> sessions = cinema.find(session -> session.equals(session1));
        assertThat(sessions).containsOnly(session1);
    }

    @Test
    public void whenBuyOnPastDateThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar pastDate = Calendar.getInstance();
        pastDate.set(2000, Calendar.JANUARY, 1);
        assertThatThrownBy(() -> cinema.buy(account, 1, 1, pastDate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenAddDuplicateSessionThenItExistsOnce() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).containsOnlyOnce(session);
    }
}