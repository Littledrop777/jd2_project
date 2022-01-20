package by.academy.it.dao.impl;

import by.academy.it.dao.AppUserDao;
import by.academy.it.entity.AppUser;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AppUserDaoImpl extends BaseDao<AppUser, String> implements AppUserDao {

    private static final String FIND_BY_LOGIN_QUERY = "SELECT u FROM AppUser u WHERE u.login=:u_login";

    public AppUserDaoImpl() {
        super(AppUser.class);
    }

    @Override
    public AppUser findByLogin(String login) {
        Session session = getSession();
            Query<AppUser> query = session.createQuery(FIND_BY_LOGIN_QUERY, AppUser.class);
            query.setParameter("u_login", login);
        return query.uniqueResult();
    }
}

