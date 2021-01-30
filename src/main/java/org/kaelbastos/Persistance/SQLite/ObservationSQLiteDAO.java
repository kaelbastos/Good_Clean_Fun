package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.utils.Observation;
import org.kaelbastos.Persistance.DAOs.DAO;

import java.util.List;
import java.util.Optional;

public class ObservationSQLiteDAO implements DAO<String, Observation>{

    @Override
    public boolean save(Observation observation) {
        return false;
    }

    @Override
    public boolean update(Observation observation) {
        return false;
    }

    @Override
    public Optional<Observation> getOne(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Observation>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
