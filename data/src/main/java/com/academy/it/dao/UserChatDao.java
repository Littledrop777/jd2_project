package com.academy.it.dao;

import com.academy.it.dto.UserChatDto;
import com.academy.it.entity.UserChat;

import java.util.List;

public interface UserChatDao extends Dao<UserChat, String> {

    UserChat findByFirstUserIdAndSecondUserId(String firstUserId, String secondUserId);

    List<UserChatDto> findAllByUserId(String userId, int first, int max);

    long countUserChatsByUserId(String userId);
}
