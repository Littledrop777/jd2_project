package by.academy.it.service;

import by.academy.it.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface AppService<E extends BaseEntity<K>, K extends Serializable> {

    E save(E entity);

    List<E> findAll();

    E findById(K id);

    void update(E entity);

    void delete(K id);
}
