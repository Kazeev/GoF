package com.company;

import java.time.LocalDate;
import java.util.List;

class PremiumLevel implements SeasonTicket {
    String name;
    List<LocalDate> visitingDays;

    @Override
    public String toString() {
        return "Премиум-уровень на сезон" +
               "\tимя: " + name +
               "\tдаты посещения: " + visitingDays.toString();
    }

    @Override
    public void buy() {
        System.out.println("Премиум уровень на сезон добавлен");
    }

    @Override
    public void getDays() {
        System.out.println(visitingDays.toString());
    }

    @Override
    public void setDays(List<LocalDate> days) {
        visitingDays = days;
    }

    @Override
    public void getUserName() {
        System.out.println("Имя клиента " + name);
    }

    @Override
    public void setUserName(String name) {
        this.name = name;
    }

    @Override
    public void extend() {

    }

    @Override
    public void pass() {
        System.out.println("Вы продли PremiumLevel");
    }
}
