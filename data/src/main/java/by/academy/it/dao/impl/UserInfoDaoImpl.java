package by.academy.it.dao.impl;

import by.academy.it.dao.UserInfoDao;
import by.academy.it.entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo, String> implements UserInfoDao {

    private static final String FIND_BY_EMAIL_QUERY = "SELECT inf FROM UserInfo inf WHERE inf.email=:email";

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
}
