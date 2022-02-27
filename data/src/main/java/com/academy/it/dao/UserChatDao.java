package com.academy.it.dao;

import com.academy.it.entity.UserChat;

import java.util.List;

public interface UserChatDao extends Dao<UserChat, String> {

    List<UserChat> findByUserId(String userId);

    long countUserChatsByUserId(String userId);
}
