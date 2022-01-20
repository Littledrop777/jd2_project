package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(path = {"/", "/login.html"})
    public ModelAndView home(){
        return new ModelAndView("login");
    }
}
