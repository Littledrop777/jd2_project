package com.academy.it.controller;

import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserProfileController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/{login}/profile.html")
    public ModelAndView showUserProfile(@PathVariable String login, HttpServletRequest request) {
        if (request.getSession().getAttribute("currentUser") == null) {
            return new ModelAndView("redirect:/login.html");
        }
        AppUserInfoDto userInfoDto = appUserService.findUserWIthInfoByLogin(login);
        return new ModelAndView("profile")
                .addObject("userInfoDto", userInfoDto);
    }
}
