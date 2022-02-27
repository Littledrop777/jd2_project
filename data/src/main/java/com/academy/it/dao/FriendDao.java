package com.academy.it.dao;

import com.academy.it.dto.UserFriendDto;
import com.academy.it.entity.Friend;

import java.util.List;

public interface FriendDao extends Dao<Friend, String> {

    List<UserFriendDto> findFriendsByUserId(String userId, int first, int max);

    List<UserFriendDto> findRequestsByUserId(String userId, int first, int max);

    List<UserFriendDto> findRequestsFromByUserId(String userId, int first, int max);

    Friend findByUserIdAndFriendId(String userId, String friendId);

    long countFriendsResult(String userId);

    long countRequestsResult(String userId);

    long countRequestsFromResult(String userId);

}
