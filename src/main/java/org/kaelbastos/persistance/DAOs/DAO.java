package org.kaelbastos.persistance.DAOs;

<<<<<<< refs/remotes/origin/in_development
import java.util.List;

public interface DAO <K,T>{
    boolean save(T t);
    boolean update(T t);
    T getOne(K k);
    List<T> getAll();
    boolean delete(K k);

=======
public interface DAO <K,T>{
    int save(T t);
    int update(K k, T t);
    int getOne(K k);
    int getAll();
    int delete(K k);
>>>>>>> Deleted controller package and included first test scope
}
