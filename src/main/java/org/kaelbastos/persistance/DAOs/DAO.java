package org.kaelbastos.persistance.DAOs;

import java.util.List;

public interface DAO <K,T>{
    boolean save(T t);
    boolean update(T t);
    T getOne(K k);
    List<T> getAll();
    boolean delete(K k);

}
