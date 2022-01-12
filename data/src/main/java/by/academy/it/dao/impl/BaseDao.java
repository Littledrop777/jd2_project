package by.academy.it.dao.impl;

import by.academy.it.dao.Dao;
import by.academy.it.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseDao<E extends BaseEntity<K>, K extends Serializable> implements Dao<E, K> {

    @Autowired
    protected SessionFactory sessionFactory;
    private final Class<E> clazz;

    public BaseDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E save(E entity) {
        getCurrentSession().save(entity);
        getCurrentSession().flush();
        return entity;
    }

    @Override
    public List<E> findAll() {
        String className = clazz.getSimpleName();
        return getCurrentSession().createQuery("FROM " + className, clazz).list();

    }

    @Override
    public E findById(K id) {
        return getCurrentSession().get(clazz, id);
    }

    @Override
    public void update(E entity) {
        getCurrentSession().update(entity);
        getCurrentSession().flush();
    }

    @Override
    public void delete(K id) {
        Session session = sessionFactory.getCurrentSession();
        E entity = session.get(clazz, id);
        session.delete(entity);
        session.flush();
    }
}
