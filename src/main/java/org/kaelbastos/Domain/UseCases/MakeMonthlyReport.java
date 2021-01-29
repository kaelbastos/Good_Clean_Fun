package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MakeMonthlyReport {
    public boolean execute(int month){
        Optional<List<Service>> allServices = PersistenceFacade.getInstance().getAllServices();
        if(allServices.isEmpty())
            throw new RuntimeException("No Services saved.");
        else
            System.out.println(assembleReport(month));
        return true;
    }

    private String assembleReport(int month){
        Optional<List<Service>> allServices = PersistenceFacade.getInstance().getAllServices();
        if (allServices.isPresent()) {
            String services = (String) allServices.get().stream()
                    .filter(service -> service.getStart().getMonthValue() == month)
                    .map(Service::toString)
                    .collect(Collectors.joining("\n"));
            return "Services {" + services + "};\n";
        }
        return "No services in the selected Month;";
    }
}
