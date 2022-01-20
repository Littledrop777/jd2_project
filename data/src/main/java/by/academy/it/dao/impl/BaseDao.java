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

<<<<<<< HEAD
    protected Session getSession() {
=======
    protected Session getCurrentSession() {
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E save(E entity) {
<<<<<<< HEAD
        getSession().save(entity);
        getSession().flush();
=======
        getCurrentSession().save(entity);
        getCurrentSession().flush();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
        return entity;
    }

    @Override
    public List<E> findAll() {
        String className = clazz.getSimpleName();
<<<<<<< HEAD
        return getSession().createQuery("FROM " + className, clazz).list();
=======
        return getCurrentSession().createQuery("FROM " + className, clazz).list();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

    }

    @Override
    public E findById(K id) {
<<<<<<< HEAD
        return getSession().get(clazz, id);
=======
        return getCurrentSession().get(clazz, id);
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
    }

    @Override
    public void update(E entity) {
<<<<<<< HEAD
        getSession().update(entity);
        getSession().flush();
=======
        getCurrentSession().update(entity);
        getCurrentSession().flush();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
    }

    @Override
    public void delete(K id) {
        Session session = sessionFactory.getCurrentSession();
        E entity = session.get(clazz, id);
        session.delete(entity);
        session.flush();
    }
}
