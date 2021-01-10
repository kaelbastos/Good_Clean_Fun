package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceStatus;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.Optional;

public class FinishService {
    public boolean finish(int serviceId){
        Optional<Service> optionalService = PersistenceFacade.getInstance()
                .getOneService(serviceId);
        if(optionalService.isEmpty())
            throw new IllegalArgumentException("Service does not exists.");
        else
            optionalService.get().setStatus(ServiceStatus.Done);
        return true;
    }
}
