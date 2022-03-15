package com.academy.it.dao.impl;

import com.academy.it.dao.UserChatDao;
import com.academy.it.dto.UserChatDto;
import com.academy.it.entity.UserChat;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserChatDaoImpl extends BaseDao<UserChat, String> implements UserChatDao {

    private static final String FIND_BY_FIRST_USER_ID_SECOND_USER_ID_QUERY =
            "SELECT u_ch FROM UserChat u_ch " +
                    "WHERE (u_ch.firstUser.id = :first_user_id AND u_ch.secondUser.id = :second_user_id) " +
                    " OR (u_ch.firstUser.id = :second_user_id AND u_ch.secondUser.id = :first_user_id) ";

    private static final String FIND_BY_USER_ID_QUERY =
            "SELECT new com.academy.it.dto.UserChatDto(u_ch.id, u.id, u.login, ch.appUser.login, ch.message, ch.createTime) " +
                    "FROM UserChat u_ch, " +
                    "     AppUser u," +
                    "     Chat ch " +
                    "WHERE (u_ch.firstUser.id = :user_id OR u_ch.secondUser.id = :user_id) " +
                    "  AND ch.userChat.id = u_ch.id " +
                    "  AND ch.createTime = (SELECT MAX(c.createTime) FROM Chat c WHERE c.userChat.id = u_ch.id) " +
                    "  AND u.id = CASE" +
                    "                   WHEN u_ch.firstUser.id = :user_id THEN u_ch.secondUser.id " +
                    "                   WHEN u_ch.secondUser.id = :user_id THEN u_ch.firstUser.id " +
                    "  END " +
                    "  ORDER BY ch.createTime DESC";

    private static final String COUNT_USERS_CHATS_RESULT =
            "SELECT count(u_ch.id) " +
                    "FROM UserChat u_ch " +
                    "WHERE u_ch.firstUser.id = :user_id " +
                    "OR u_ch.secondUser.id = :user_id";

    public UserChatDaoImpl() {
        super(UserChat.class);
    }

    @Override
    public UserChat findByFirstUserIdAndSecondUserId(String firstUserId, String secondUserId) {
        Session session = getSession();
        Query<UserChat> query = session.createQuery(FIND_BY_FIRST_USER_ID_SECOND_USER_ID_QUERY, UserChat.class);
        query.setParameter("first_user_id", firstUserId);
        query.setParameter("second_user_id", secondUserId);
        return query.uniqueResult();
    }

    @Override
    public List<UserChatDto> findAllByUserId(String userId, int first, int max) {
        Session session = getSession();
        Query<UserChatDto> query = session.createQuery(FIND_BY_USER_ID_QUERY, UserChatDto.class);
        query.setParameter("user_id", userId)
                .setFirstResult(first)
                .setMaxResults(max);
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
