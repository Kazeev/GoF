package com.company;

enum SingleTicketType {
    SingleDayPremiumLevel("\n\t(1) Одно премеум посещение"),
    SingleDayFirstLevel("\n\t(2) Одно базовое посещение");

    public String name;

    SingleTicketType(String name) {
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
