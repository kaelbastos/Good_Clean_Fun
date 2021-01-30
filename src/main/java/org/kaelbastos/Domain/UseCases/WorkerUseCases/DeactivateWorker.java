package org.kaelbastos.Domain.UseCases.WorkerUseCases;

import org.kaelbastos.Domain.CustomExceptions.EntityDoesNotExistsException;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.Optional;

public class DeactivateWorker {
    public boolean deactivate(String workerId){
        Optional<Worker> optionalWorker = PersistenceFacade.getInstance()
                .getOneWorker(workerId);
        if(optionalWorker.isEmpty())
            throw new EntityDoesNotExistsException("Worker");
        else
            optionalWorker.get().setActive(false);
        return true;
    }
}
