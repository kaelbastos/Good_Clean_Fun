package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ClientValidator;
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
            throw new IllegalArgumentException("Worker does not exists");

        return persistenceFacade.updateWorker(worker);
    }
}
