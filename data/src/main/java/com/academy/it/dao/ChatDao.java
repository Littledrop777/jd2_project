package com.academy.it.dao;

import com.academy.it.dto.ChatDto;
import com.academy.it.entity.Chat;

import java.util.List;

public interface ChatDao extends Dao<Chat, String>{

    List<ChatDto> findAllByUserChatId(String userChatId, int first, int max);

    long countMessagesByUserChatId(String userChatId);
}
