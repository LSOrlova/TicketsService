package ru.netology;

import java.util.Comparator;

public class DurationComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTripTime() - o2.getTripTime();
    }
}
