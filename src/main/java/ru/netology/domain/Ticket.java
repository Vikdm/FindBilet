package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ticket implements Comparable<Ticket> {

    private int id;
    private int amount;
    private String from;
    private String to;
    private int time;

    public Ticket(int id, int amount, String from, String to, int time) {
        this.id = id;
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public boolean matchFrom(String query1) {
        return from.contains(query1);
    }

    public boolean matchTo(String query2) {
        return to.contains(query2);
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (amount < otherTicket.amount) {
            return -1;
        }
        if (amount > otherTicket.amount) {
            return 1;
        }
        return 0;
    }
}
