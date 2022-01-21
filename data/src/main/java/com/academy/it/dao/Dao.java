package com.academy.it.dao;

import com.academy.it.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface Dao <E extends BaseEntity<K>, K extends Serializable>{

    E save(E t);

    List<E> findAll();

    E findById(K id);

    void update(E t);

    void delete(K id);
}
