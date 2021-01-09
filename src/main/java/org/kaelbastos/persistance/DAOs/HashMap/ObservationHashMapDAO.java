package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.utils.Observation;
import org.kaelbastos.persistance.DAOs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ObservationHashMapDAO implements DAO <String, Observation> {
    private static ObservationHashMapDAO dao = null;
    private final HashMap<String, Observation> map;

    public ObservationHashMapDAO(HashMap<String, Observation> map) {
        this.map = map;
    }

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
