package org.kaelbastos.Domain.UseCases.ReportUseCases;

import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenerateUnpaidServicesReport {
    public Optional<List<Service>> generate(){
        Optional<List<Service>> services = PersistenceFacade.getInstance().getAllServices();
        return services.map(serviceList -> serviceList.stream()
                .filter(service -> !service.isPayed()).collect(Collectors.toList()));
    }
}
