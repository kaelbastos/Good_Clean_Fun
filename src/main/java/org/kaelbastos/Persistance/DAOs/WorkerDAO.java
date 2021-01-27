package org.kaelbastos.Persistance.DAOs;

import org.kaelbastos.Domain.Entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Observation;

import java.util.ArrayList;
import java.util.Optional;

public abstract class WorkerDAO implements DAO<String, Worker> {
    public abstract Optional<ArrayList<Observation>> getObservationsFromWorker(String workerId);
    public abstract Optional<ArrayList<DayOfWeekRestriction>> getDayOfWeekRestrictionFromWorker(String workerId);
}
