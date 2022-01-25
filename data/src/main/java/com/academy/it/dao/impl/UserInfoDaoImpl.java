package com.academy.it.dao.impl;

import com.academy.it.dao.UserInfoDao;
import com.academy.it.entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo, String> implements UserInfoDao {

    private static final String FIND_BY_EMAIL_QUERY = "SELECT inf FROM UserInfo inf WHERE inf.email=:email";
    private static final String FIND_BY_USER_ID_QUERY = "SELECT inf FROM UserInfo inf WHERE inf.appUser.id=:user_id";

    public UserInfoDaoImpl() {
        super(UserInfo.class);
    }

    @Override
    public UserInfo findByEmail(String email) {
        Session session = getSession();
        Query<UserInfo> query = session.createQuery(FIND_BY_EMAIL_QUERY, UserInfo.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    @Override
    public UserInfo findByUserId(String userId) {
        Session session = getSession();
        Query<UserInfo> query = session.createQuery(FIND_BY_USER_ID_QUERY, UserInfo.class);
        query.setParameter("user_id", userId);
        return query.uniqueResult();
    }
}
