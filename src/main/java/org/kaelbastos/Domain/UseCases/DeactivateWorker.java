package org.kaelbastos.Domain.UseCases;

import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.Optional;

public class DeactivateWorker {
    public boolean deactivate(String workerId){
        Optional<Worker> optionalWorker = PersistenceFacade.getInstance()
                .getOneWorker(workerId);
        if(optionalWorker.isEmpty())
            throw new IllegalArgumentException("Worker does not exists.");
        else
            optionalWorker.get().setActive(false);
        return true;
    }
}
