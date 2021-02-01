package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Persistance.DAOs.DayOfWeekDAO;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DayOfWeekRestrictionSQLiteDAO extends DayOfWeekDAO {
    @Override
    public boolean save(DayOfWeek dayOfWeek) {
        return false;
    }

    @Override
    public boolean update(DayOfWeek dayOfWeek) {
        return false;
    }

    @Override
    public Optional<DayOfWeek> getOne(LocalDateTime localDateTime) {
        return Optional.empty();
    }

    @Override
    public Optional<List<DayOfWeek>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(LocalDateTime localDateTime) {
        return false;
    }
}
