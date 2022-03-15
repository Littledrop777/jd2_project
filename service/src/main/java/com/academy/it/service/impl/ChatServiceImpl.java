package com.academy.it.service.impl;

import com.academy.it.dao.ChatDao;
import com.academy.it.dao.UserChatDao;
import com.academy.it.dto.ChatDto;
import com.academy.it.dto.UserChatDto;
import com.academy.it.entity.AppUser;
import com.academy.it.entity.Chat;
import com.academy.it.entity.UserChat;
import com.academy.it.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    private final ChatDao chatDao;
    private final UserChatDao userChatDao;

    @Autowired
    public ChatServiceImpl(ChatDao chatDao, UserChatDao userChatDao) {
        this.chatDao = chatDao;
        this.userChatDao = userChatDao;
    }

    @Override
    public UserChat addNewUserChat(AppUser firstUser, AppUser secondUser) {
        UserChat userChat = new UserChat();
        userChat.setFirstUser(firstUser);
        userChat.setSecondUser(secondUser);
        userChat.setCreateDate(Instant.now());
        return userChatDao.save(userChat);
    }

    @Override
    public void addNewMessage(UserChat userChat, AppUser sender, String message) {
        Chat chat = new Chat();
        chat.setUserChat(userChat);
        chat.setAppUser(sender);
        chat.setMessage(message);
        chat.setCreateTime(LocalDateTime.now());
        chatDao.save(chat);
    }

    @Override
    public UserChat findByFirstUserIdAndSecondUserId(String firstUserId, String secondUserId) {
        return userChatDao.findByFirstUserIdAndSecondUserId(firstUserId, secondUserId);
    }

    @Override
    public List<ChatDto> findMessagesByUserChatId(String userChatId, int first, int max) {
        return chatDao.findAllByUserChatId(userChatId, first, max);
    }

    @Override
    public List<UserChatDto> findDialogsByUserId(String userId, int first, int max) {
        return userChatDao.findAllByUserId(userId, first, max);
    }

    @Override
    public long countUserChatsByUserId(String userId) {
        return userChatDao.countUserChatsByUserId(userId);
    }

    @Override
    public long countMessagesByUserChatId(String userChatId) {
        return chatDao.countMessagesByUserChatId(userChatId);
    }
}
