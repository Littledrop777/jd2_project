package com.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @GetMapping("/logout-user.html")
    public ModelAndView logoutUser(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("redirect:/login.html");
    }
}
