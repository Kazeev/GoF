package com.company;

enum SeasonTicketType {
    PremiumLevel("\n\t(1) Абонемент премеум уровня"),
    FirstLevel("\n\t(2) Абонемент базового уровня");

    public String name;

    SeasonTicketType(String name) {
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
