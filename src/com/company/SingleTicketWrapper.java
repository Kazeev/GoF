package com.company;

import java.time.LocalDate;
import java.util.List;

class SingleTicketWrapper implements SeasonTicket {

    SingleTicket singleTicket;

    public SingleTicketWrapper(SingleTicket singleTicket) {
        this.singleTicket = singleTicket;
    }

    @Override
    public void buy() {

    }

    @Override
    public void getDays() {

    }

    @Override
    public void setDays(List<LocalDate> days) {

    }

    @Override
    public void getUserName() {

    }

    @Override
    public void setUserName(String name) {

    }

    @Override
    public void extend() {

    }

    @Override
    public void pass() {
        singleTicket.passTicket();
    }
}
