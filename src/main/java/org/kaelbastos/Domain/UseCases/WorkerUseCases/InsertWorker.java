package org.kaelbastos.Domain.UseCases.WorkerUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityAlreadyExistsException;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.Worker.WorkerValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class InsertWorker {
    public boolean insert(Worker worker) throws Exception{
        WorkerValidator workerValidator = new WorkerValidator();
        Notification notification = workerValidator.validate(worker);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneWorker(worker.getCpf()).isPresent() ||
                persistenceFacade.getOneClient(worker.getCpf()).isPresent())
            throw new EntityAlreadyExistsException("Person");

        return persistenceFacade.saveWorker(worker);
    }
}
