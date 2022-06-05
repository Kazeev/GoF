package com.company;

class SingleTicketFactory implements Ticket {
    public Object create(Enum typeOfSingleTicket) {
        return switch ((SingleTicketType) typeOfSingleTicket) {
            case SingleDayPremiumLevel -> new SingleDayPremiumLevel();
            case SingleDayFirstLevel -> new SingleDayFirstLevel();
        };
    }
}
