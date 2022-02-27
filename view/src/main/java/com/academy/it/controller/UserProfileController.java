package com.academy.it.controller;

import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.entity.Friend;
import com.academy.it.entity.Status;
import com.academy.it.service.AppUserService;
import com.academy.it.service.FriendService;
import com.academy.it.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserProfileController {

    private final AppUserService appUserService;
    private final FriendService friendService;

    @Autowired
    public UserProfileController(AppUserService appUserService, FriendService friendService) {
        this.appUserService = appUserService;
        this.friendService = friendService;
    }

    @GetMapping("/{id}/profile.html")
    public ModelAndView showUserProfile(@PathVariable String id,
                                        HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("profile");
        AppUserInfoDto userInfoDto = appUserService.findUserWIthInfoById(id);
        String userId = (String) session.getAttribute("userId");
        Status status = null;
        if (userId != null && !userId.equals(id) && friendService.findByUserIdAndFriendId(userId, id).isPresent()) {
            status = friendService.findByUserIdAndFriendId(userId, id).get().getStatus();
        }
        modelAndView.addObject("userInfoDto", userInfoDto)
                .addObject("status", status);
        return modelAndView;
    }
}
