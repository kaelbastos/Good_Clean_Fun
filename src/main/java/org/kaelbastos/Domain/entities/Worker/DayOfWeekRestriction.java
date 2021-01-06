package org.kaelbastos.Domain.entities.Worker;

import java.time.DayOfWeek;
public class DayOfWeekRestriction {
    private DayOfWeek day;
    private String motive;

    public DayOfWeekRestriction(DayOfWeek day, String motive) {
        this.day = day;
        this.motive = motive;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

}
