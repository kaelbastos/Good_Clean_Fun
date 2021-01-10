package org.kaelbastos.Domain.Entities.Worker;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekRestrictionTest {


    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = LocalDateTime.of(LocalDate.ofYearDay(2021, 200), LocalTime.NOON);
    String motive = "A Motive";
    DayOfWeekRestriction dayOfWeekRestriction = new DayOfWeekRestriction(start, end, motive);

    @Order(1)
    @Test
    void getStart() {
        assertEquals(start, dayOfWeekRestriction.getStart());
    }
    @Order(2)
    @Test
    void setStart() {
        LocalDateTime newStart = LocalDateTime.of(2021, 01, 06, 20, 54);
        dayOfWeekRestriction.setStart(newStart);
        assertEquals(newStart, dayOfWeekRestriction.getStart());
    }

    @Order(3)
    @Test
    void getEnd() {
        assertEquals(end, dayOfWeekRestriction.getEnd());
    }

    @Order(4)
    @Test
    void setEnd() {
        LocalDateTime newEnd = LocalDateTime.of(2021, 12, 25, 00, 00);
        dayOfWeekRestriction.setEnd(newEnd);
        assertEquals(newEnd, dayOfWeekRestriction.getEnd());
    }

    @Order(5)
    @Test
    void getMotive() {
        assertEquals(motive, dayOfWeekRestriction.getMotive());
    }

    @Order(6)
    @Test
    void setMotive() {
        String newMotive = "new Motive";
        dayOfWeekRestriction.setMotive(newMotive);
        assertEquals(newMotive, dayOfWeekRestriction.getMotive());
    }
}