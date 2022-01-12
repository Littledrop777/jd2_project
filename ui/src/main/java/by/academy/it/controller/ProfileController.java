package by.academy.it.controller;

import by.academy.it.dto.AddNewUserCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @GetMapping("/profile.html")
    public ModelAndView profileView(){
        return new ModelAndView("profile")
                .addObject("addNewUserCommand", new AddNewUserCommand());
    }
}
