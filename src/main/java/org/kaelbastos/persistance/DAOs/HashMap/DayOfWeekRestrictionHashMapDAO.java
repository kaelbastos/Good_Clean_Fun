package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Worker.DayOfWeekRestriction;
import org.kaelbastos.persistance.DAOs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class DayOfWeekRestrictionHashMapDAO implements DAO <String, DayOfWeekRestriction> {
    private static DayOfWeekRestrictionHashMapDAO dao = null;
    private final HashMap<String, DayOfWeekRestriction> map;

    public DayOfWeekRestrictionHashMapDAO(HashMap<String, DayOfWeekRestriction> map) {
        this.map = map;
    }

    @Override
    public boolean save(DayOfWeekRestriction dayOfWeekRestriction) {
        return false;
    }

    @Override
    public boolean update(DayOfWeekRestriction dayOfWeekRestriction) {
        return false;
    }

    @Override
    public Optional<DayOfWeekRestriction> getOne(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<DayOfWeekRestriction>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
