package org.kaelbastos.Persistance.HashMap;

import org.kaelbastos.Domain.Entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Persistance.PersistenceFacade;
import org.kaelbastos.Persistance.DAOs.WorkerDAO;

import java.util.*;

public class WorkerHashMapDAO extends WorkerDAO {
    private final HashMap<String, Worker> map = new HashMap<>();

    @Override
    public boolean save(Worker worker) {

        if (worker != null && !map.containsKey(worker.getCpf())){
            if(PersistenceFacade.getInstance().getOneClient(worker.getCpf()).isPresent())
                return false;
            map.put(worker.getCpf(), worker);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Worker updatedWorker) {
        if (updatedWorker == null || !map.containsKey(updatedWorker.getCpf()))
            return false;
        else
            map.replace(updatedWorker.getCpf(), updatedWorker);
        return true;
    }

    @Override
    public Optional<Worker> getOne(String s) {
        return Optional.ofNullable(map.get(s));
    }

    @Override
    public Optional<List<Worker>> getAll() {
        return Optional.of(new ArrayList<>(map.values()));
    }

    @Override
    public boolean delete(String s) {
        return map.remove(s) != null;
    }

    @Override
    public Optional<ArrayList<Observation>> getObservationsFromWorker(String workerId) {
        return Optional.ofNullable(map.get(workerId).getObservations());
    }
    @Override
    public Optional<ArrayList<DayOfWeekRestriction>> getDayOfWeekRestrictionFromWorker(String workerId) {
        return Optional.ofNullable((ArrayList<DayOfWeekRestriction>)map.get(workerId).getDayOfWeekRestrictions());
    }
}
