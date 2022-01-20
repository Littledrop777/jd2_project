package by.academy.it.service;

import by.academy.it.dao.Dao;
import by.academy.it.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class BaseService<E extends BaseEntity<K>, K extends Serializable> implements AppService<E, K> {

    private Dao<E, K> dao;

    public BaseService(@Autowired Dao<E, K> dao) {
        this.dao = dao;
    }

    @Override
    public E save(E entity) {
        return dao.save(entity);
    }

    @Override
    public List<E> findAll() {
        return dao.findAll();
    }

    @Override
    public E findById(K id) {
        return dao.findById(id);
    }

    @Override
    public void update(E entity) {
        dao.update(entity);
    }

    @Override
    public void delete(K id) {
        dao.delete(id);
    }
}
