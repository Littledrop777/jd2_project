package com.academy.it.dao.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.AppUserChatDto;
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
            "SELECT new com.academy.it.dto.AppUserInfoDto(u.id, u.login, inf.firstname, inf.lastname, inf.email, inf.birthday, inf.gender, inf.avatarId) " +
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

    private static final String FIND_BY_USER_CHAT_ID_QUERY =
            "SELECT new com.academy.it.dto.AppUserChatDto(u_ch.id, u.id, u.login, ui.firstname, ui.lastname) " +
                    "FROM AppUser u " +
                    "         JOIN UserChat u_ch on u.id = CASE " +
                    "                      WHEN u_ch.firstUser.id = :user_chat_id THEN u_ch.secondUser.id" +
                    "                      WHEN u_ch.secondUser.id = :user_chat_id THEN u_ch.firstUser.id" +
                    "    END " +
                    "         JOIN UserInfo ui on u.id = ui.appUser.id " +
                    "WHERE u.id = CASE " +
                    "                      WHEN u_ch.firstUser.id = :user_chat_id THEN u_ch.secondUser.id" +
                    "                      WHEN u_ch.secondUser.id = :user_chat_id THEN u_ch.firstUser.id" +
                    "    END";

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

    @Override
    public List<AppUserChatDto> findAllByUserChatId(String userChatId, int first, int max) {
        Session session = getSession();
        Query<AppUserChatDto> result = session.createQuery(FIND_BY_USER_CHAT_ID_QUERY, AppUserChatDto.class);
        result.setParameter("user_chat_id", userChatId);
        return result.list();
    }
}

