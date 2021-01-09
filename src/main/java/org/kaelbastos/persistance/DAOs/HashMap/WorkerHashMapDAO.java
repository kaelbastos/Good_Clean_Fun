package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Worker.Worker;
import org.kaelbastos.persistance.DAOs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class WorkerHashMapDAO implements DAO <String, Worker> {
    private static WorkerHashMapDAO dao = null;
    private final HashMap<String, Worker> map;

    public WorkerHashMapDAO(HashMap<String, Worker> map) {
        this.map = map;
    }

    @Override
    public boolean save(Worker worker) {
        return false;
    }

    @Override
    public boolean update(Worker worker) {
        return false;
    }

    @Override
    public Optional<Worker> getOne(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Worker>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
