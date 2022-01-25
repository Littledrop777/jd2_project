package com.academy.it.dao.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.entity.AppUser;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserDaoImpl extends BaseDao<AppUser, String> implements AppUserDao {

    private static final String FIND_BY_LOGIN_QUERY = "SELECT u FROM AppUser u WHERE u.login=:u_login";
    private static final String FIND_USER_INFO_BY_ID_QUERY =
            "SELECT new com.academy.it.dto.AppUserInfoDto(u.login, inf.firstname, inf.lastname, inf.email, inf.birthday, inf.gender, inf.image) " +
                    "FROM AppUser u " +
                    "JOIN UserInfo inf on u.id = inf.appUser.id " +
                    "WHERE u.id = :u_id";

    private static final String FIND_BY_CRITERIA_QUERY =
            "SELECT new com.academy.it.dto.SearchUserResultDto(u.id, u.login, inf.firstname, inf.lastname) " +
                    "FROM AppUser u " +
                    "JOIN UserInfo inf on u.id = inf.appUser.id " +
                    "WHERE LOWER(u.login)  LIKE LOWER('%%%s%%') " +
                    "OR LOWER(inf.firstname)  LIKE LOWER('%%%s%%') " +
                    "OR LOWER(inf.lastname)  LIKE LOWER('%%%s%%')";


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
    public AppUserInfoDto findUserWIthInfoById(String id) {
        Session session = getSession();
        Query<AppUserInfoDto> query = session.createQuery(FIND_USER_INFO_BY_ID_QUERY, AppUserInfoDto.class);
        query.setParameter("u_id", id);
        return query.uniqueResult();
    }

    @Override
    public List<SearchUserResultDto> findAllByCriteria(String criteria, int first, int max) {
        Session session = getSession();
        String query = String.format(FIND_BY_CRITERIA_QUERY, criteria, criteria, criteria);
        Query<SearchUserResultDto> result = session.createQuery(query, SearchUserResultDto.class);
        result.setFirstResult(first);
        result.setMaxResults(max);
        return result.list();
    }
}

