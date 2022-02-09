package com.academy.it.controller;

import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.entity.Image;
import com.academy.it.service.AppUserService;
import com.academy.it.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfileController {

    private AppUserService appUserService;
    private ImageService imageService;

    @Autowired
    public UserProfileController(AppUserService appUserService, ImageService imageService) {
        this.appUserService = appUserService;
        this.imageService = imageService;
    }

    @GetMapping("/{id}/profile.html")
    public ModelAndView showUserProfile(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("profile");
        AppUserInfoDto userInfoDto = appUserService.findUserWIthInfoById(id);
        modelAndView.addObject("userInfoDto", userInfoDto);
        return modelAndView;
    }
}
