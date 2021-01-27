package org.kaelbastos.Persistance.HashMap;

import org.junit.jupiter.api.Test;
import org.kaelbastos.Domain.Entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.Domain.Entities.Worker.Worker;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Domain.Entities.utils.ObservationType;
import static org.junit.jupiter.api.Assertions.*;
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
        assertTrue(workerHashMapDAO.save(worker));
    }

    @Test
    void saveSameWorkerTwice() {
        assertTrue(workerHashMapDAO.save(worker));
        assertFalse(workerHashMapDAO.save(worker));
    }

    @Test
    void saveNullWorker() {
        assertFalse(workerHashMapDAO.save(null));
    }

    @Test
    void updateWorker() {
        assertTrue(workerHashMapDAO.save(worker));
        worker.setEmail("test@test.com");
        assertTrue(workerHashMapDAO.update(worker));
    }

    @Test
    void deleteWorker() {
        assertTrue(workerHashMapDAO.save(worker));
        assertTrue(workerHashMapDAO.delete("12345678910"));
    }

    @Test
    void deleteSameWorkerTwice() {
        assertTrue(workerHashMapDAO.save(worker));
        assertTrue(workerHashMapDAO.delete("12345678910"));
        assertFalse(workerHashMapDAO.delete("12345678910"));
    }

    @Test
    void getAllWorkersWithoutWorkersSaved() {
        assertTrue(workerHashMapDAO.getAll().get().isEmpty());
    }

    @Test
    void getNoWorkersFromAllWorkers() {
        assertFalse(workerHashMapDAO.getAll().isEmpty());
    }

    @Test
    void getOneWorkerWithNullKey() {
        assertFalse(workerHashMapDAO.getOne(null).isPresent());
    }

    @Test
    void getNonExistingWorker() {
        assertFalse(workerHashMapDAO.getOne("0").isPresent());
    }

    @Test
    void getOneWorkerBlankParameter() {
        assertFalse(workerHashMapDAO.getOne("      ").isPresent());
    }

    @Test
    void getObservationsFromWorker() {
        assertTrue(workerHashMapDAO.save(worker));
        Observation observation = new Observation(ObservationType.Comment, "Comment", worker);
        worker.addObservation(observation);
        assertTrue(workerHashMapDAO.getObservationsFromWorker("12345678910").isPresent());
    }

    @Test
    void getDayOfWeekRestrictionFromWorker() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.of(LocalDate.ofYearDay(2021, 200), LocalTime.NOON);
        assertTrue(workerHashMapDAO.save(worker));
        DayOfWeekRestriction dayOfWeekRestriction = new DayOfWeekRestriction(start, end);
        worker.addDayOfWeekRestrictions(dayOfWeekRestriction);
        assertTrue(workerHashMapDAO.getDayOfWeekRestrictionFromWorker("12345678910").isPresent());
    }

}