package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.Worker.WorkerValidator;
import org.kaelbastos.Domain.Entities.utils.Notification;
import org.kaelbastos.Persistance.PersistenceFacade;

public class InsertWorker {
    public boolean insert(Worker worker){
        WorkerValidator workerValidator = new WorkerValidator();
        Notification notification = workerValidator.validate(worker);

        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.getMessage());
        else if(persistenceFacade.getOneWorker(worker.getCpf()).isPresent() ||
                persistenceFacade.getOneClient(worker.getCpf()).isPresent())
            throw new IllegalArgumentException("CPF already exists");

        return persistenceFacade.saveWorker(worker);
    }
}
