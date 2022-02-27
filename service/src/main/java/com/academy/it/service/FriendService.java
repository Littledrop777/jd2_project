package com.academy.it.service;

import com.academy.it.dto.UserFriendDto;
import com.academy.it.entity.Friend;
import com.academy.it.entity.Status;

import java.util.List;
import java.util.Optional;

public interface FriendService {

    Status addFriend(String userId, String friendId);

    void saveFriendship(Friend friend);

    void updateFriendship(Friend friend);

    List<UserFriendDto> findAllFriendsByUserId(String userId, int first, int max);

    List<UserFriendDto> findRequestsByUserId(String userId, int first, int max);

    List<UserFriendDto> findRequestsFromByUserId(String userId, int first, int max);

    Optional<Friend> findByUserIdAndFriendId(String userId, String friendId);

    long countFriendsResult(String userId);

    long countRequestsResult(String userId);

    long countRequestsFromResult(String userId);

    void deleteFriend(String userId, String friendId);
}
