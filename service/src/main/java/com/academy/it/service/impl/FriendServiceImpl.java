package com.academy.it.service.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dao.FriendDao;
import com.academy.it.dto.UserFriendDto;
import com.academy.it.entity.AppUser;
import com.academy.it.entity.Friend;
import com.academy.it.entity.Status;
import com.academy.it.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    private final FriendDao friendDao;
    private final AppUserDao userDao;

    @Autowired
    public FriendServiceImpl(FriendDao friendDao, AppUserDao userDao) {
        this.friendDao = friendDao;
        this.userDao = userDao;
    }

    @Override
    public Status addFriend(String userId, String friendId) {
        AppUser user = userDao.findById(userId);
        AppUser friend = userDao.findById(friendId);
        Friend friendship = friendDao.findByUserIdAndFriendId(userId, friendId);
        if (friendship != null && friendship.getStatus().equals(Status.REQUESTED)) {
            friendship.setStatus(Status.ACCEPTED);
            this.updateFriendship(friendship);
        } else {
            friendship = new Friend();
            friendship.setFirstFriend(user);
            friendship.setSecondFriend(friend);
            friendship.setStatus(Status.REQUESTED);
            this.saveFriendship(friendship);
        }
        return friendship.getStatus();
    }

    @Override
    public void saveFriendship(Friend friend) {
        friend.setCreateDate(Instant.now());
        friendDao.save(friend);
    }

    @Override
    public void updateFriendship(Friend friend) {
        friend.setUpdateDate(Instant.now());
        friendDao.update(friend);
    }

    @Override
    public List<UserFriendDto> findAllFriendsByUserId(String userId, int first, int max) {
        return friendDao.findFriendsByUserId(userId, first, max);
    }

    @Override
    public List<UserFriendDto> findRequestsByUserId(String userId, int first, int max) {
        return friendDao.findRequestsByUserId(userId, first, max);
    }

    @Override
    public List<UserFriendDto> findRequestsFromByUserId(String userId, int first, int max) {
        return friendDao.findRequestsFromByUserId(userId, first, max);
    }

    @Override
    public Optional<Friend> findByUserIdAndFriendId(String userId, String friendId) {
        return Optional.ofNullable(friendDao.findByUserIdAndFriendId(userId, friendId));
    }

    @Override
    public long countFriendsResult(String userId) {
        return friendDao.countFriendsResult(userId);
    }

    @Override
    public long countRequestsResult(String userId) {
        return friendDao.countRequestsResult(userId);
    }

    @Override
    public long countRequestsFromResult(String userId) {
        return friendDao.countRequestsFromResult(userId);
    }

    @Override
    public void deleteFriend(String userId, String friendId) {
        Friend friendship = friendDao.findByUserIdAndFriendId(userId, friendId);
        friendDao.delete(friendship.getId());
    }

}
