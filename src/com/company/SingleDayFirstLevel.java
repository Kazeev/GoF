package com.company;

import java.time.LocalDate;

class SingleDayFirstLevel implements SingleTicket {
    LocalDate visitingDay;

    @Override
    public void buy() {
        System.out.println("Вы купили первый уровень на один день");
    }

    @Override
    public void getUserName() {

    }

    @Override
    public void setUserName(String name) {

    }

    @Override
    public void getDay() {
        System.out.println("Дни вашего посещения" + visitingDay.toString());
    }

    @Override
    public void setDay(LocalDate day) {
        visitingDay = day;
    }


    @Override
    public void passTicket() {
        System.out.println("Проданно SingleDayFirstLevel");
    }
}
