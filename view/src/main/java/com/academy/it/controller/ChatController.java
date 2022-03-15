package com.academy.it.controller;

import com.academy.it.dto.ChatDto;
import com.academy.it.dto.UserChatDto;
import com.academy.it.entity.AppUser;
import com.academy.it.entity.UserChat;
import com.academy.it.service.AppUserService;
import com.academy.it.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final AppUserService userService;

    @Autowired
    public ChatController(ChatService chatService, AppUserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @GetMapping("/{receiverUserId}/user-chat.html")
    public ModelAndView showChat(@PathVariable String receiverUserId,
                                 @RequestParam(name = "page", required = false, defaultValue = "1") String pageNumber,
                                 HttpSession session) {
        int page = Integer.parseInt(pageNumber);
        String senderUserId = (String) session.getAttribute("userId");
        UserChat userChat = chatService.findByFirstUserIdAndSecondUserId(senderUserId, receiverUserId);
        List<ChatDto> messages;
        long pageAmount;
        if (userChat != null) {
            long messageAmount = chatService.countMessagesByUserChatId(userChat.getId());
            int max = 10;
            int first = (page - 1) * max;
            pageAmount = (int) Math.ceil(messageAmount /(double) max);
            messages = chatService.findMessagesByUserChatId(userChat.getId(), first, max);
        }else {
            messages = Collections.emptyList();
            pageAmount = 0;
        }
        return new ModelAndView("messages")
                .addObject("secondUserId", receiverUserId)
                .addObject("messages", messages)
                .addObject("pageAmount", pageAmount);
    }

    @PostMapping("/{receiverUserId}/send-message.do")
    public ModelAndView sendMessage(@PathVariable String receiverUserId,
                                    @RequestParam String message,
                                    HttpSession session) {
        String senderUserId = (String) session.getAttribute("userId");
        AppUser sender = userService.findById(senderUserId);
        AppUser receiver = userService.findById(receiverUserId);
        UserChat userChat = chatService.findByFirstUserIdAndSecondUserId(senderUserId, receiverUserId);
        if (userChat == null) {
            userChat = chatService.addNewUserChat(sender, receiver);
        }
        chatService.addNewMessage(userChat, sender, message);
        return new ModelAndView("redirect:/" + receiverUserId + "/user-chat.html");
    }

    @GetMapping("/{page}/chats.html")
    public ModelAndView showAllChats(@PathVariable int page,
                                     HttpSession session) {
        String userId = String.valueOf(session.getAttribute("userId"));
        int max = 10;
        int first = (page - 1) * max;
        long chatsAmount = chatService.countUserChatsByUserId(userId);
        int pageAmount = (int) Math.ceil(chatsAmount /(double) max);
        List<UserChatDto> dialogs = chatService.findDialogsByUserId(userId, first, max);
        return new ModelAndView("chat")
                .addObject("dialogs", dialogs)
                .addObject("pageAmount", pageAmount);
    }
}
