package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(1, 500, "VIE", "ALY", 375);
    Ticket ticket2 = new Ticket(2, 400, "VIE", "TLV", 245);
    Ticket ticket3 = new Ticket(3, 600, "TLV", "VRN", 195);
    Ticket ticket4 = new Ticket(4, 300, "ETS", "TLV", 240);
    Ticket ticket5 = new Ticket(5, 250, "VIE", "ETS", 90);
    Ticket ticket6 = new Ticket(6, 50, "VIE", "ETS", 90);

    @Test
    void testAddTicket() {
        TicketRepository ticketRepository = new TicketRepository();
        ticketRepository.addTicket(ticket1);
        ticketRepository.addTicket(ticket2);
        ticketRepository.addTicket(ticket3);
        ticketRepository.addTicket(ticket4);
        ticketRepository.addTicket(ticket5);
        ticketRepository.addTicket(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = ticketRepository.getAllTickets();
        assertArrayEquals(expected, actual);

    }

    @Test
    void removeTicketById() {
        TicketRepository ticketRepository = new TicketRepository();
        ticketRepository.addTicket(ticket1);
        ticketRepository.addTicket(ticket2);
        ticketRepository.addTicket(ticket3);
        ticketRepository.addTicket(ticket4);
        ticketRepository.addTicket(ticket5);
        ticketRepository.addTicket(ticket6);
        ticketRepository.removeTicketById(4);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5, ticket6};
        Ticket[] actual = ticketRepository.getAllTickets();
        assertArrayEquals(expected, actual);
    }
}