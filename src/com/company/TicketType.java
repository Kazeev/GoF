package com.company;

enum TicketType {
    SingleTicketFactory("\n\t(1) Одиночное посещение"),
    SeasonTicketFactory("\n\t(2) Абонемент");
    public String name;

    TicketType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
