package com.company;

import java.time.LocalDate;
import java.util.List;

class FirstLevel implements SeasonTicket {
    @Override
    public String toString() {
        return "FirstLevel";
    }

    @Override
    public void buy() {
        System.out.println("Первый уровень на сезон  добавлен");
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
        System.out.println("Вы продли FirstLevel");
    }
}
