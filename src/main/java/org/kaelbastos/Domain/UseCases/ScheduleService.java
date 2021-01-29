package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityAlreadyExistsException;
import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class ScheduleService {
    public boolean schedule(Service service){
        ServiceValidator serviceValidator = new ServiceValidator();
        Notification notification = serviceValidator.validate(service);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors()){
            throw new IllegalArgumentException(notification.getMessage());
        } else {
            if(persistenceFacade.getOneClient(service.getClient().getCpf()).isEmpty())
                notification.addError("Client does not exists.");

            service.getWorkers().forEach(worker -> {
                if(persistenceFacade.getOneWorker(worker.getCpf()).isEmpty())
                    notification.addError("Worker does not exists.");
                });

            service.getProducts().forEach(product -> {
                if(persistenceFacade.getOneProduct(product.getId()).isEmpty())
                    notification.addError("Product does not exists.");
            });

            if(persistenceFacade.getOneService(service.getId()).isPresent())
                notification.addError("Service Already Exists");

            if(notification.hasErrors())
                throw new RuntimeException(notification.getMessage());
        }
        return persistenceFacade.saveService(service);
    }
}

