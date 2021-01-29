package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityDoesNotExistsException;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.Worker.WorkerValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class AlterWorker {
    public boolean alter(Worker worker){
        WorkerValidator workerValidator = new WorkerValidator();
        Notification notification = workerValidator.validate(worker);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneWorker(worker.getCpf()).isEmpty())
            throw new EntityDoesNotExistsException("Worker");

        return persistenceFacade.updateWorker(worker);
    }
}
