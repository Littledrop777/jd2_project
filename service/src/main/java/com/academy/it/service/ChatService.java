package com.academy.it.service;

import com.academy.it.dto.ChatDto;
import com.academy.it.dto.UserChatDto;
import com.academy.it.entity.AppUser;
import com.academy.it.entity.UserChat;

import java.util.List;

public interface ChatService {

    UserChat addNewUserChat(AppUser firstUser, AppUser secondUser);

    void addNewMessage(UserChat userChat, AppUser sender, String message);

    UserChat findByFirstUserIdAndSecondUserId(String firstUserId, String secondUserId);

    List<ChatDto> findMessagesByUserChatId(String userChatId, int first, int max);

    List<UserChatDto> findDialogsByUserId(String userId, int first, int max);

    long countUserChatsByUserId(String userId);

    long countMessagesByUserChatId(String userChatId);
}
