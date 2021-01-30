package org.kaelbastos.Domain.UseCases.ServiceUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityDoesNotExistsException;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.util.Optional;

public class CancelScheduledService {

    public boolean cancel(int serviceId){
        Optional<Service> optionalService = PersistenceFacade.getInstance()
                .getOneService(serviceId);
        if(optionalService.isEmpty())
            throw new EntityDoesNotExistsException("Service");
        else
            optionalService.get().setStatus(ServiceStatus.Canceled);
        return true;
    }
}
