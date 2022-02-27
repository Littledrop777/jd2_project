package com.academy.it.controller;

import com.academy.it.service.impl.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/user-chat.html")
    public ModelAndView showChat() {
        return new ModelAndView();
    }

    @PostMapping("/send-message.do")
    public ModelAndView sendMessage() {
        return new ModelAndView();
    }

    @GetMapping("/chats.html")
    public ModelAndView showAllChats(HttpSession session) {
        String userId = String.valueOf(session.getAttribute("userId"));
        chatService.findAllByUserChatId(userId);
        return new ModelAndView();
    }
}
