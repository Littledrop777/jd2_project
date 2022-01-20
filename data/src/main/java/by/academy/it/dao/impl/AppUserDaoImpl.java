package by.academy.it.dao.impl;

import by.academy.it.dao.AppUserDao;
import by.academy.it.entity.AppUser;
import org.hibernate.Session;
<<<<<<< HEAD
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
=======
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

@Repository
public class AppUserDaoImpl extends BaseDao<AppUser, String> implements AppUserDao {

<<<<<<< HEAD
    private static final String FIND_BY_LOGIN_QUERY = "SELECT u FROM AppUser u WHERE u.login=:u_login";
=======
    //public static final String UPDATE_QUERY = "UPDATE AppUser SET login=:u_login, password=:u_password WHERE id=:u_id";
    public static final String FIND_BY_LOGIN_QUERY = "FROM AppUser WHERE login=:u_login";
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

    public AppUserDaoImpl() {
        super(AppUser.class);
    }

    @Override
    public AppUser findByLogin(String login) {
<<<<<<< HEAD
        Session session = getSession();
=======
        Session session = getCurrentSession();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
            Query<AppUser> query = session.createQuery(FIND_BY_LOGIN_QUERY, AppUser.class);
            query.setParameter("u_login", login);
        return query.uniqueResult();
    }
}

