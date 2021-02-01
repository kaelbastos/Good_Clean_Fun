package org.kaelbastos.Domain.UseCases.ReportUseCases;

import org.kaelbastos.Domain.Entities.Reports.ProfitMonthReport;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.utils.Validator;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class GenerateProfitMonthReport {
    public List<ProfitMonthReport> generate() throws Exception {
        HashMap<LocalDate, ProfitMonthReport> report = new HashMap<>();

        Optional<List<Service>> services = PersistenceFacade.getInstance().getAllServices();

        if (services.isEmpty())
            throw new RuntimeException("No Services Saved");

        services.get().stream()
                .sorted(Comparator.comparing(Service::getStart))
                .forEachOrdered(service -> {
                    int year = service.getStart().getYear();
                    Month month = service.getStart().getMonth();
                    LocalDate date = LocalDate.of(year, month, 1);
                    if(Validator.isNotNull(report.get(date))){
                        ProfitMonthReport profit = report.get(date);
                        profit.setProfit(profit.getProfit() + service.getProfit());
                        report.replace(date, profit);
                    } else {
                        ProfitMonthReport profit = new ProfitMonthReport(Year.of(year), month, service.getProfit());
                    }
                });

        return (List<ProfitMonthReport>) report.values();
    }
}
