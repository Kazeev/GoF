package com.company;

interface TicketAbstractFactory {
    static Ticket createTicket(TicketType typeOfTicket) {
        return switch (typeOfTicket) {
            case SingleTicketFactory -> new SingleTicketFactory();
            case SeasonTicketFactory -> new SeasonTicketFactory();
        };
    }
}
