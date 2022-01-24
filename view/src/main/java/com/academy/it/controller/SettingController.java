package com.academy.it.controller;

import com.academy.it.dto.UpdateUserDto;
import com.academy.it.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class SettingController {

    private final AppUserService userService;

    @Autowired
    public SettingController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/settings.html")
    public ModelAndView showSettingsView(HttpServletRequest request) {
        if (request.getSession().getAttribute("currentUser") == null) {
            return new ModelAndView("redirect:/login.html");
        }
        return new ModelAndView("settings")
                .addObject("updateUserDto", new UpdateUserDto());
    }

    @PostMapping("/{id}/update-settings.do")
    public ModelAndView updateSettings(@PathVariable String id,
                                       @ModelAttribute("updateUserDto")
                                       @Valid UpdateUserDto updateUserDto,
                                       BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("settings")
                    .addObject("error", result.getAllErrors().get(0).getDefaultMessage());
        }
        userService.updateUser(updateUserDto, id);
        return new ModelAndView("settings")
                .addObject("message", "Successful update")
                .addObject("updateUserDto", new UpdateUserDto());
    }
}
