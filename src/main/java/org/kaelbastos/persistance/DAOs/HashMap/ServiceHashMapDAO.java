package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.Service.Service;
import org.kaelbastos.persistance.DAOs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ServiceHashMapDAO implements DAO <Integer, Service> {
    private static ServiceHashMapDAO dao = null;
    private final HashMap<String, Service> map;

    public ServiceHashMapDAO(HashMap<String, Service> map) {
        this.map = map;
    }

    @Override
    public boolean save(Service service) {
        return false;
    }

    @Override
    public boolean update(Service service) {
        return false;
    }

    @Override
    public Optional<Service> getOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Service>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
