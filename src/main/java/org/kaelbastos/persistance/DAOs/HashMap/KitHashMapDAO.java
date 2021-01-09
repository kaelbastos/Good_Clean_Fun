package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Product.Kit;
import org.kaelbastos.persistance.DAOs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class KitHashMapDAO implements DAO <String, Kit>{
    private static KitHashMapDAO dao = null;
    private final HashMap<String, Kit> map;

    public KitHashMapDAO(HashMap<String, Kit> map) {
        this.map = map;
    }

    @Override
    public boolean save(Kit kit) {
        return false;
    }

    @Override
    public boolean update(Kit kit) {
        return false;
    }

    @Override
    public Optional<Kit> getOne(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Kit>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
