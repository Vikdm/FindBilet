package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TicketTest {

    TicketRepo repo = new TicketRepo();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1111, 1_999, "DME", "LED", 70);
    Ticket ticket2 = new Ticket(2222, 40_000, "SVO", "DXB", 250);
    Ticket ticket3 = new Ticket(3333, 12_000, "VKO", "COJ", 60);
    Ticket ticket4 = new Ticket(4444, 2_000, "DME", "BAX", 210);
    Ticket ticket5 = new Ticket(5555, 5_000, "SVO", "LED", 65);

    @Test
    public void delTest1() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] actual = repo.deleteTicket(3333);
        Ticket[] expected = {ticket1, ticket4, ticket5, ticket2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void delTest2() {

        Ticket[] actual = repo.deleteTicket(11);
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void delTest3() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] actual = repo.deleteTicket(1111);
        Ticket[] expected = {ticket4, ticket5, ticket3, ticket2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void findTest1() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] actual = manager.findTicketManager("DME", "LED");
        Ticket[] expected = {ticket1, ticket4, ticket5};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void findTest2() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] actual = manager.findTicketManager("SVO", "COJ");
        Ticket[] expected = {ticket5, ticket3, ticket2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void findTest3() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] actual = manager.findTicketManager("FGT", "YTE" );
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void findTest4() {

        Ticket[] actual = manager.findTicketManager("SVO", "COJ");
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void findTest5() {
        repo.add(ticket1);

        Ticket[] actual = manager.findTicketManager("DME", "COJ");
        Ticket[] expected = {ticket1};

        assertArrayEquals(actual, expected);
    }

}

