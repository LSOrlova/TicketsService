package ru.netology;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void add(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    public Ticket[] getTickets() {
        Ticket[] all = ticketRepository.getAllTickets();
        return all;
    }


    public Ticket[] searchBy(String text1, String text2) {
        Ticket[] result = new Ticket[0];
        PriceComparator priceComparator = new PriceComparator();
        for (Ticket ticket : ticketRepository.getAllTickets()) {
            if (matchesDeparture(ticket, text1) && matchesArrival(ticket, text2)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result, priceComparator);
            }
        }

        return result;

    }
    public Ticket[] findAll(String text1, String text2, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        PriceComparator priceComparator = new PriceComparator();
        for (Ticket ticket : ticketRepository.getAllTickets()) {
            if (matchesDeparture(ticket, text1) && matchesArrival(ticket, text2)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result, comparator);
            }
        }

        return result;

    }


    public boolean matchesArrival(Ticket ticket, String search) {
        if (ticket.getAirportArrival().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesDeparture(Ticket ticket, String search) {
        if (ticket.getAirportDeparture().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
    // ???????????? ???????????? ???????????????????? ?????????? ?????????????????????? ?????????? ?????????????? (???? ???????????? ???? ??????)
//    private boolean matches(Ticket ticket, String from, String to) {
//
//    }
}

