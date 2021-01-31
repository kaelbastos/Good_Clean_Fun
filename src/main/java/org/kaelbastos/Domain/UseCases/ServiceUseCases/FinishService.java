package org.kaelbastos.Domain.UseCases.ServiceUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityDoesNotExistsException;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.Optional;

public class FinishService {
    public boolean finish(int serviceId) throws Exception{
        Optional<Service> optionalService = PersistenceFacade.getInstance()
                .getOneService(serviceId);
        if(optionalService.isEmpty())
            throw new EntityDoesNotExistsException("Service");
        else
            optionalService.get().setStatus(ServiceStatus.Done);
            optionalService.get().setPayed(true);
        return true;
    }
}
