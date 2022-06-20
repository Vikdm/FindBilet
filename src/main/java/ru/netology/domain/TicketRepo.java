package ru.netology.domain;

import java.util.Arrays;

public class TicketRepo {
    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        int len = tickets.length + 1;
        Ticket[] tmp = new Ticket[len];

        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        int lastTicket = tmp.length - 1;
        tmp[lastTicket] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] deleteTicket(int id) {
        if (tickets.length == 0) {
            return new Ticket[0];
        }
        int len = tickets.length - 1;
        Ticket[] tmp = new Ticket[len];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        Arrays.sort(tmp);
        tickets = tmp;
        return tickets;
    }

}
