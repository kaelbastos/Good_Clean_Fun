package org.kaelbastos.Domain.UseCases.ServiceUseCases;

import org.kaelbastos.Domain.Entities.Service.Service;
import org.kaelbastos.Domain.Entities.Service.ServiceValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ScheduleService {
    public boolean schedule(Service service) throws Exception {
        ServiceValidator serviceValidator = new ServiceValidator();
        Notification notification = serviceValidator.validate(service);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.getMessage());
        } else {
            if (persistenceFacade.getOneClient(service.getClient().getCpf()).isEmpty())
                notification.addError("Client does not exists.");

            service.getWorkers().forEach(worker -> {
                if (persistenceFacade.getOneWorker(worker.getCpf()).isEmpty())
                    notification.addError("Worker does not exists.");

                Optional<List<Service>> workerServices = persistenceFacade.getServiceByWorker(worker.getCpf());
                workerServices.ifPresent(services -> services.forEach(workerService -> {
                    if (workerService.getStart().isBefore(service.getStart())) {
                        LocalDateTime workerServiceStart = workerService.getStart();
                        if (workerServiceStart.plusHours((long) workerService.getCategory().getDuration()).isAfter(service.getStart()))
                            notification.addError("Worker Already Has Service in this time");
                    } else {
                        LocalDateTime workerServiceStart = workerService.getStart();
                        if (service.getStart().plusHours((long) workerService.getCategory().getDuration()).isAfter(workerService.getStart()))
                            notification.addError("Worker Already Has Service in this time");
                    }
                }));
            });

            service.getProducts().forEach(product -> {
                if (persistenceFacade.getOneProduct(product.getId()).isEmpty())
                    notification.addError("Product does not exists.");
            });

            if (persistenceFacade.getOneService(service.getId()).isPresent())
                notification.addError("Service Already Exists");


            if (notification.hasErrors())
                throw new RuntimeException(notification.getMessage());
        }
        return persistenceFacade.saveService(service);
    }
}

