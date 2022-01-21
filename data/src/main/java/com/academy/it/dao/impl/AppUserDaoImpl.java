package com.academy.it.dao.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.entity.AppUser;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDaoImpl extends BaseDao<AppUser, String> implements AppUserDao {

    private static final String FIND_BY_LOGIN_QUERY = "SELECT u FROM AppUser u WHERE u.login=:u_login";
    private static final String FIND_USER_INFO_BY_LOGIN_QUERY =
            "SELECT new com.academy.it.dto.AppUserInfoDto(u.login, inf.firstname, inf.lastname, inf.email, inf.birthday, inf.gender) " +
                    "FROM AppUser u, UserInfo inf " +
                    "WHERE u.login=:u_login";

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

    @Override
    public AppUserInfoDto findUserWIthInfoByLogin(String login) {
        Session session = getSession();
        Query<AppUserInfoDto> query = session.createQuery(FIND_USER_INFO_BY_LOGIN_QUERY, AppUserInfoDto.class);
        query.setParameter("u_login", login);
        return query.uniqueResult();
    }
}

