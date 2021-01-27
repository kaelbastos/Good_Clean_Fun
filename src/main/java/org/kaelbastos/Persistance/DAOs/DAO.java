package org.kaelbastos.Persistance.DAOs;

import java.util.List;
import java.util.Optional;

public interface DAO <K,T>{
    boolean save(T t);
    boolean update(T t);
    Optional<T> getOne(K k);
    Optional<List<T>> getAll();
    boolean delete(K k);
}
