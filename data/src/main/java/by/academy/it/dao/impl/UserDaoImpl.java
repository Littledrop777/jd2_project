package by.academy.it.dao.impl;

import by.academy.it.dao.UserDao;
import by.academy.it.model.User;
import by.academy.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    public static final String UPDATE_QUERY = "UPDATE User SET login=:u_login, password=:u_password WHERE id=:u_id";
    public static final String FIND_BY_LOGIN_QUERY = "FROM User WHERE login=:u_login";
    private final SessionFactory sessionFactory;

    public UserDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(UPDATE_QUERY);
            query.setParameter("u_login", user.getLogin());
            query.setParameter("u_password", user.getPassword());
            query.setParameter("u_id", user.getId());
            int i = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(FIND_BY_LOGIN_QUERY);
            query.setParameter("u_login", login);
            user = (User)query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Optional.ofNullable(user);
    }
}
