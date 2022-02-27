package com.academy.it.dao.impl;

import com.academy.it.dao.FriendDao;
import com.academy.it.dto.UserFriendDto;
import com.academy.it.entity.Friend;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendDaoImpl extends BaseDao<Friend, String> implements FriendDao {

    private static final String FIND_ALL_BY_USER_ID_QUERY =
            "SELECT new com.academy.it.dto.UserFriendDto(user.id, user.login, inf.firstname, inf.lastname, fr.status) " +
                    "FROM Friend fr, " +
                    "     AppUser user " +
                    "    JOIN UserInfo inf ON user.id = inf.appUser.id " +
                    "WHERE user.id = CASE " +
                    "          WHEN fr.firstFriend.id = :user_id THEN fr.secondFriend.id " +
                    "          WHEN fr.secondFriend.id = :user_id THEN fr.firstFriend.id " +
                    "    END " +
                    "AND inf.appUser.id = user.id " +
                    "AND fr.status = 'ACCEPTED'";

    private static final String COUNT_FRIENDS_RESULT_QUERY =
            "SELECT count(fr.id) " +
                    "FROM Friend fr " +
                    "WHERE (fr.firstFriend.id = :user_id OR fr.secondFriend.id = :user_id) " +
                    "  AND fr.status = 'ACCEPTED'";

    private static final String FIND_REQUESTS_BY_USER_ID_QUERY =
            "SELECT new com.academy.it.dto.UserFriendDto(user.id, user.login, inf.firstname, inf.lastname, fr.status) " +
                    "FROM Friend fr, " +
                    "     AppUser user " +
                    "    JOIN UserInfo inf ON user.id = inf.appUser.id " +
                    "WHERE fr.firstFriend.id = :user_id " +
                    "  AND user.id = fr.secondFriend.id " +
                    "  AND inf.appUser.id = user.id " +
                    "  AND fr.status = 'REQUESTED'";

    private static final String COUNT_REQUESTS_RESULT_QUERY =
            "SELECT count(fr.id) " +
                    "FROM Friend fr " +
                    "WHERE fr.firstFriend.id = :user_id " +
                    "  AND fr.status = 'REQUESTED'";

    private static final String FIND_REQUESTS_FROM_BY_USER_ID_QUERY =
            "SELECT new com.academy.it.dto.UserFriendDto(user.id, user.login, inf.firstname, inf.lastname, fr.status) " +
                    "FROM Friend fr, " +
                    "     AppUser user " +
                    "    JOIN UserInfo inf ON user.id = inf.appUser.id " +
                    "WHERE fr.secondFriend.id = :user_id " +
                    "  AND user.id = fr.firstFriend.id " +
                    "  AND inf.appUser.id = user.id " +
                    "  AND fr.status = 'REQUESTED'";

    private static final String COUNT_REQUESTS_FROM_RESULT_QUERY =
            "SELECT count(fr.id) " +
                    "FROM Friend fr " +
                    "WHERE fr.secondFriend.id = :user_id " +
                    "  AND fr.status = 'REQUESTED'";

    private static final String FIND_BY_USER_ID_AND_FRIEND_ID_QUERY =
            "SELECT fr " +
                    "FROM Friend fr " +
                    "WHERE (fr.firstFriend.id  = :user_id " +
                    "           AND fr.secondFriend.id = :friend_id) " +
                    "    OR (fr.secondFriend.id = :user_id " +
                    "           AND fr.firstFriend.id  = :friend_id) ";


    public FriendDaoImpl() {
        super(Friend.class);
    }

    @Override
    public List<UserFriendDto> findFriendsByUserId(String userId, int first, int max) {
        return findAllUserFriends(FIND_ALL_BY_USER_ID_QUERY, userId, first, max);
    }

    @Override
    public List<UserFriendDto> findRequestsByUserId(String userId, int first, int max) {
        return findAllUserFriends(FIND_REQUESTS_BY_USER_ID_QUERY, userId, first, max);
    }

    @Override
    public List<UserFriendDto> findRequestsFromByUserId(String userId, int first, int max) {
        return findAllUserFriends(FIND_REQUESTS_FROM_BY_USER_ID_QUERY, userId, first, max);
    }

    @Override
    public Friend findByUserIdAndFriendId(String userId, String friendId) {
        Session session = getSession();
        Query<Friend> query = session.createQuery(FIND_BY_USER_ID_AND_FRIEND_ID_QUERY, Friend.class);
        query.setParameter("user_id", userId);
        query.setParameter("friend_id", friendId);
        return query.uniqueResult();
    }

    @Override
    public long countFriendsResult(String userId) {
        return countResult(COUNT_FRIENDS_RESULT_QUERY, userId);
    }

    @Override
    public long countRequestsResult(String userId) {
        return countResult(COUNT_REQUESTS_RESULT_QUERY, userId);
    }

    @Override
    public long countRequestsFromResult(String userId) {
        return countResult(COUNT_REQUESTS_FROM_RESULT_QUERY, userId);
    }

    private List<UserFriendDto> findAllUserFriends(String query, String userId, int first, int max){
        Session session = getSession();
        Query<UserFriendDto> result = session.createQuery(query, UserFriendDto.class);
        result.setParameter("user_id", userId)
                .setFirstResult(first)
                .setMaxResults(max);
        return result.list();
    }

    private long countResult(String query, String userId) {
        Session session = getSession();
        Query<Long> result = session.createQuery(query, Long.class);
        result.setParameter("user_id", userId);
        return result.uniqueResult();
    }
}
