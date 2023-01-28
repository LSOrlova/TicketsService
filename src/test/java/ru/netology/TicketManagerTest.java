package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, 500, "VIE", "ALY", 375);
    Ticket ticket2 = new Ticket(2, 400, "VIE", "TLV", 245);
    Ticket ticket3 = new Ticket(3, 600, "TLV", "VRN", 195);
    Ticket ticket4 = new Ticket(4, 300, "ETS", "TLV", 240);
    Ticket ticket5 = new Ticket(5, 150, "VIE", "ETS", 90);



    @Test
    public void testShouldAddTicket() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);

        Ticket[] actual = ticketManager.getTickets();
        Ticket[] expected = {ticket1, ticket2, ticket3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void searchBy() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);

        Ticket[] actual = ticketManager.searchBy("VIE", "TLV");
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testShouldSearchMatchesArrival() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);

        boolean actual = ticketManager.matchesArrival(ticket2, "TLV");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testShouldSearchMatchesDeparture() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);

        boolean actual = ticketManager.matchesDeparture(ticket3, "TLV");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
}