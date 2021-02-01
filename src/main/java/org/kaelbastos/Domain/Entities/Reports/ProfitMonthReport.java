package org.kaelbastos.Domain.Entities.Reports;

import java.time.Month;
import java.time.Year;

public class ProfitMonthReport {
    private Year year;
    private Month month;
    private double profit;

    public ProfitMonthReport(Year year, Month month, double profit) {
        this.year = year;
        this.month = month;
        this.profit = profit;
    }

    public Year getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
