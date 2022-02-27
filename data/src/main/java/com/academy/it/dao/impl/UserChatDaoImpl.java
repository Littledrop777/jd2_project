package com.academy.it.dao.impl;

import com.academy.it.dao.UserChatDao;
import com.academy.it.entity.UserChat;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserChatDaoImpl extends BaseDao<UserChat, String> implements UserChatDao {

    private static final String FIND_BY_USER_ID_QUERY =
            "SELECT u_ch " +
                    "FROM UserChat u_ch " +
                    "WHERE u_ch.firstUser.id = :user_id " +
                    "   OR u_ch.secondUser.id = :user_id";

    private static final String COUNT_USERS_CHATS_RESULT=
            "SELECT count(u_ch.id) " +
                    "FROM UserChat u_ch " +
                    "WHERE u_ch.firstUser.id = :user_id " +
                    "OR u_ch.secondUser.id = :user_id";

    public UserChatDaoImpl() {
        super(UserChat.class);
    }

    @Override
    public List<UserChat> findByUserId(String userId) {
        Session session = getSession();
        Query<UserChat> query = session.createQuery(FIND_BY_USER_ID_QUERY, UserChat.class);
        query.setParameter("user_id", userId);
        return query.list();
    }

    @Override
    public long countUserChatsByUserId(String userId) {
        Session session = getSession();
        Query<Long> result = session.createQuery(COUNT_USERS_CHATS_RESULT, Long.class);
        result.setParameter("user_id", userId);
        return result.uniqueResult();
    }
}
