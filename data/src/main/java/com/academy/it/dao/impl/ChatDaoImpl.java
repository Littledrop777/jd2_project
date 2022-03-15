package com.academy.it.dao.impl;

import com.academy.it.dao.ChatDao;
import com.academy.it.dto.ChatDto;
import com.academy.it.entity.Chat;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatDaoImpl extends BaseDao<Chat, String> implements ChatDao {

    private static final String FIND_ALL_BY_USER_CHAT_ID_QUERY =
            "SELECT new com.academy.it.dto.ChatDto(ch.appUser.id, u.login, ch.message, ch.createTime) " +
                    "FROM Chat ch " +
                    "         JOIN AppUser u on u.id = ch.appUser.id " +
                    "WHERE ch.userChat.id = :user_chat_id " +
                    "ORDER BY ch.createTime DESC";

    private static final String COUNT_MESSAGES_QUERY =
            "SELECT count(ch.id) " +
                    "FROM Chat ch " +
                    "WHERE ch.userChat.id = :user_chat_id ";

    public ChatDaoImpl() {
        super(Chat.class);
    }

    @Override
    public List<ChatDto> findAllByUserChatId(String userChatId, int first, int max) {
        Session session = getSession();
        Query<ChatDto> query = session.createQuery(FIND_ALL_BY_USER_CHAT_ID_QUERY, ChatDto.class);
        query.setParameter("user_chat_id", userChatId)
                .setFirstResult(first)
                .setMaxResults(max);
        return query.list();
    }

    @Override
    public long countMessagesByUserChatId(String userChatId) {
        Session session = getSession();
        Query<Long> result = session.createQuery(COUNT_MESSAGES_QUERY, Long.class);
        result.setParameter("user_chat_id", userChatId);
        return result.uniqueResult();
    }
}
