package org.kaelbastos.persistance.DAOs.HashMap;

import org.junit.jupiter.api.Test;
import org.kaelbastos.Domain.entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.entities.Worker.Worker;
import org.kaelbastos.Domain.entities.utils.Address;
import org.kaelbastos.Domain.entities.utils.Observation;
import org.kaelbastos.Domain.entities.utils.ObservationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class WorkerHashMapDAOTest {
    Worker worker = new Worker(
            "12345678910",
            "Name",
            "12345678910",
            "12345678910",
            "email@email.com",
            new Address("Street",
                    "Neighborhood",
                    "City", "State",
                    "10",
                    "12",
                    ""));

    WorkerHashMapDAO workerHashMapDAO = new WorkerHashMapDAO();

    @Test
    void saveWorker() {
        workerHashMapDAO.save(worker);
    }

    @Test
    void saveSameWorkerTwice() {
        workerHashMapDAO.save(worker);
        workerHashMapDAO.save(worker);
    }

    @Test
    void saveNullWorker() {
        workerHashMapDAO.save(null);
    }

    @Test
    void updateWorker() {
        worker.setEmail("test@test.com");
        workerHashMapDAO.update(worker);
    }

    @Test
    void deleteWorker() {
        workerHashMapDAO.delete("12345678910");
    }

    @Test
    void deleteSameWorkerTwice() {
        workerHashMapDAO.delete("12345678910");
        workerHashMapDAO.delete("12345678910");
    }

    @Test
    void getAllWorkers() {
        workerHashMapDAO.save(worker);
        workerHashMapDAO.getAll();
    }

    @Test
    void getNullFromAllWorkers() {
        workerHashMapDAO.getAll();
    }

    @Test
    void getOneWorker() {
        workerHashMapDAO.getOne("12345678910");
    }

    @Test
    void getNullWorker() {
        workerHashMapDAO.getOne("00000000000");
    }

    @Test
    void getOneWorkerNullParameter() {
        workerHashMapDAO.getOne("");
    }

    @Test
    void getOneWorkerBlankParameter() {
        workerHashMapDAO.getOne(" ");
    }

    @Test
    void getObservationsFromWorker() {
        workerHashMapDAO.save(worker);
        Observation observation = new Observation(ObservationType.Comment, "Comment", worker);
        worker.addObservation(observation);
        workerHashMapDAO.getObservationsFromWorker("12345678910");
    }

    @Test
    void getgetDayOfWeekRestrictionFromWorker() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.of(LocalDate.ofYearDay(2021, 200), LocalTime.NOON);
        workerHashMapDAO.save(worker);
        DayOfWeekRestriction dayOfWeekRestriction = new DayOfWeekRestriction(start, end);
        worker.addDayOfWeekRestrictions(dayOfWeekRestriction);
        workerHashMapDAO.getDayOfWeekRestrictionFromWorker("12345678910");
    }

}