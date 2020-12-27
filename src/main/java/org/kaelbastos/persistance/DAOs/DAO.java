package org.kaelbastos.persistance.DAOs;

public interface DAO <K,T>{
    int save(T t);
    int update(K k, T t);
    int getOne(K k);
    int getAll();
    int delete(K k);
}
