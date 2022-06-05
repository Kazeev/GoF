package com.company;

import java.time.LocalDate;

class SingleDayPremiumLevel implements SingleTicket {
    LocalDate visitingDay;
    String name;

    @Override
    public String toString() {
        return "Премиум-уровень на один день" +
               "\tимя: " + name +
               "\tдата посещения: " + visitingDay;
    }

    @Override
    public void buy() {
        System.out.println("Премиум уровень на один день добавлен");
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
    public void getDay() {
        System.out.println("Дата посещения" + visitingDay.toString());
    }

    @Override
    public void setDay(LocalDate day) {
        visitingDay = day;
    }

    @Override
    public void passTicket() {
        System.out.println("Вы продли SingleDayPremiumLevel");
    }
}
