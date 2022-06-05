package com.company;

import java.util.ArrayList;
import java.util.List;

class TicketRecords implements Records {
    List<Object> ticketRecords = new ArrayList<>();

    public List<Object> getTicketRecords() {
        return ticketRecords;
    }

    public void setTicketRecords(List<Object> ticketRecords) {
        this.ticketRecords = ticketRecords;
    }

    public Object addTicketRecords(Object ticketRecords) {
        return this.ticketRecords.add(ticketRecords);
    }

    @Override
    public Iterator getIterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < ticketRecords.size();
        }

        @Override
        public Object next() {
            return hasNext() ? ticketRecords.get(index++) : null;
        }
    }
}
