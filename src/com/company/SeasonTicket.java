package com.company;

import java.time.LocalDate;
import java.util.List;

interface SeasonTicket extends clubSeasonTicket {

    void buy();

    void getDays();

    void setDays(List<LocalDate> days);

    void extend();

    void pass();
}
