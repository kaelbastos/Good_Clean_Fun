package org.kaelbastos.persistance.DAOs.HashMap;

import org.kaelbastos.Domain.entities.utils.Person;
import org.kaelbastos.persistance.DAOs.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PersonHashMapDAO implements DAO <String, Person> {
    private static PersonHashMapDAO dao = null;
    private final HashMap<String, Person> map;

    public PersonHashMapDAO(HashMap<String, Person> map) {
        this.map = map;
    }

    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public boolean update(Person person) {
        return false;
    }

    @Override
    public Optional<Person> getOne(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Person>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
