package org.kaelbastos.Domain.UseCases.ServiceUseCases;

import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Validator;
import org.kaelbastos.Persistance.PersistenceFacade;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class AllocateWorker {
    public Worker allocate(ArrayList<Worker> serviceWorkers){
        Random random = new Random();
        AtomicReference<Worker> worker = new AtomicReference<>();

        PersistenceFacade.getInstance().getAllWorkers().ifPresent(workers -> {
            if(!workers.isEmpty()){
                int index = random.nextInt(workers.size());
                worker.set(workers.get(index));
            }
        });

        if (Validator.isNull(worker.get()))
            throw new RuntimeException("There is no Worker Saved");

        return worker.get();
    }
}
