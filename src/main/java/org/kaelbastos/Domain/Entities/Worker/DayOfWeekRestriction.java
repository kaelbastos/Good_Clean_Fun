package org.kaelbastos.Domain.Entities.Worker;

import java.time.LocalDateTime;
import java.util.Objects;

public class DayOfWeekRestriction {
    private LocalDateTime start;
    private LocalDateTime end;
    private String motive;

    public DayOfWeekRestriction(LocalDateTime start, LocalDateTime end, String motive) {
        this.start = start;
        this.end = end;
        this.motive = motive;
    }

    public DayOfWeekRestriction(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayOfWeekRestriction)) return false;
        DayOfWeekRestriction that = (DayOfWeekRestriction) o;
        return Objects.equals(getStart(), that.getStart()) && Objects.equals(getEnd(), that.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }

    @Override
    public String toString() {
        return "DayOfWeekRestriction{" +
                "start=" + start.toString() +
                ", end=" + end.toString() +
                ", motive='" + motive + '\'' +
                '}';
    }
}
