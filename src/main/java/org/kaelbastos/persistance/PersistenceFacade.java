package org.kaelbastos.persistance;

import org.kaelbastos.Domain.entities.Client.Client;
import org.kaelbastos.Domain.entities.Worker.Worker;
import org.kaelbastos.persistance.DAOs.HashMap.ClientHashMapDAO;
import org.kaelbastos.persistance.DAOs.HashMap.ProductHashMapDAO;
import org.kaelbastos.persistance.DAOs.HashMap.WorkerHashMapDAO;
import org.kaelbastos.persistance.Utils.CLientDAO;
import org.kaelbastos.persistance.Utils.ProductDAO;
import org.kaelbastos.persistance.Utils.WorkerDAO;

import java.util.List;
import java.util.Optional;

/* in Ingrid We Trust*/
public class PersistenceFacade {
    private static PersistenceFacade instance;

    CLientDAO clientDAO = new ClientHashMapDAO();
    ProductDAO productDAO = new ProductHashMapDAO();
    WorkerDAO workerDAO = new WorkerHashMapDAO();

    private PersistenceFacade() {}

    public static PersistenceFacade getInstance(){
        if (instance == null)
            instance = new PersistenceFacade();
        return instance;
    }

    public boolean saveWorker(Worker worker){
        return workerDAO.save(worker);
    }

    public boolean updateWorker(Worker worker){
        return workerDAO.update(worker);
    }

    public boolean deleteWorker(String workerId){
        return workerDAO.delete(workerId);
    }

    public Optional<Worker> getOneWorker(String worker){
        return workerDAO.getOne(worker);
    }

    public Optional<List<Worker>> getAllWorkers(){
        return workerDAO.getAll();
    }
}
