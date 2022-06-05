package com.company;

class SeasonTicketFactory implements Ticket {
    public Object create(Enum typeOfSeasonTicket) {
        return switch ((SeasonTicketType) typeOfSeasonTicket) {
            case PremiumLevel -> new PremiumLevel();
            case FirstLevel -> new FirstLevel();
        };
    }
}
