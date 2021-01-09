package org.kaelbastos.persistance.Utils;

import org.kaelbastos.Domain.entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.entities.Worker.Worker;
import org.kaelbastos.Domain.entities.utils.Observation;
import org.kaelbastos.Domain.entities.utils.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class WorkerDAO implements DAO<String, Worker> {
    public abstract Optional<ArrayList<Observation>> getObservationsFromWorker(String workerId);
    public abstract Optional<ArrayList<DayOfWeekRestriction>> getDayOfWeekRestrictionFromWorker(String workerId);
}
