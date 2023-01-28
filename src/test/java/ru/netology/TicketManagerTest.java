package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, 400, "VIE", "TLV", 375);
    Ticket ticket2 = new Ticket(2, 500, "VIE", "TLV", 245);
    Ticket ticket3 = new Ticket(3, 600, "TLV", "ALY", 195);
    Ticket ticket4 = new Ticket(4, 600, "TLV", "ALY", 240);
    Ticket ticket5 = new Ticket(5, 250, "VIE", "ETS", 90);
    Ticket ticket6 = new Ticket(6, 50, "VIE", "ETS", 90);


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
    void testShouldSearchByDepartureArrival() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);

        Ticket[] actual = ticketManager.searchBy("VIE", "ETS");
        Ticket[] expected = {ticket6, ticket5};
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    void testShouldSearchByDepartureArrivalFirstLowThanSecond() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);

        Ticket[] actual = ticketManager.searchBy("VIE", "TLV");
        Ticket[] expected = {ticket1, ticket2};
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    void testShouldSearchByDepartureArrivalEqualPrice() {
        TicketRepository ticketRepository = new TicketRepository();
        TicketManager ticketManager = new TicketManager(ticketRepository);
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);

        Ticket[] actual = ticketManager.searchBy("TLV", "ALY");
        Ticket[] expected = {ticket3, ticket4};
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