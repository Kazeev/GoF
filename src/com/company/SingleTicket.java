package com.company;

import java.time.LocalDate;

interface SingleTicket extends clubSeasonTicket {

    void buy();

    void getDay();

    void setDay(LocalDate day);

    void passTicket();
}
