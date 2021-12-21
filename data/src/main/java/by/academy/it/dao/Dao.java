package by.academy.it.dao;

import by.academy.it.model.Model;

import java.util.List;
import java.util.Optional;

public interface Dao <T extends Model>{

    T save(T t);

    List<T> findAll();

    Optional<T> findById(Long id);

    void update(T t);

    void delete(Long id);
}
