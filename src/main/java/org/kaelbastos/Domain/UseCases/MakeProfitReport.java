package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.List;
import java.util.Optional;

public class MakeProfitReport {
    public boolean execute(int month) {
        if(month>=1 && month<=12){
            System.out.println(assembleReport(month));
        }else
            throw new IllegalArgumentException("Month is invalid.");
        return true;
    }

    private String assembleReport(int month) {
        Optional<List<Service>> allServices = PersistenceFacade.getInstance().getAllServices();
        Optional<Float> totalProfit = allServices.get().stream()
                .filter(service -> {
                    return service.getStart().getMonthValue() == month ||
                            service.getEnd().getMonthValue() == month;
                }).map(service -> service.getServicePrice() * ((100 - service.getWorkerPercentage())/100))
                .reduce(Float::sum);
        if(totalProfit.isPresent())
            return "\n\n\nProfit: " + totalProfit.get().toString();
        return "\n\n\nUnable to retrieve profit.";
    }
}
