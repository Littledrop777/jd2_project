package com.academy.it.service.impl;

import com.academy.it.dao.ChatDao;
import com.academy.it.dto.ChatDto;
import com.academy.it.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChatService {

    private final ChatDao chatDao;

    @Autowired
    public ChatService(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    public List<ChatDto> findAllByUserChatId(String userId) {
        return chatDao.findAllByUserChatId(userId);
    }
}
