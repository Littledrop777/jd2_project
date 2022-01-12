package by.academy.it.dao.impl;

import by.academy.it.dao.AppUserDao;
import by.academy.it.entity.AppUser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AppUserDaoImpl extends BaseDao<AppUser, String> implements AppUserDao {

    //public static final String UPDATE_QUERY = "UPDATE AppUser SET login=:u_login, password=:u_password WHERE id=:u_id";
    public static final String FIND_BY_LOGIN_QUERY = "FROM AppUser WHERE login=:u_login";

    public AppUserDaoImpl() {
        super(AppUser.class);
    }

    @Override
    public AppUser findByLogin(String login) {
        Session session = getCurrentSession();
            Query<AppUser> query = session.createQuery(FIND_BY_LOGIN_QUERY, AppUser.class);
            query.setParameter("u_login", login);
        return query.uniqueResult();
    }
}

