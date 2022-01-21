package by.academy.it.controller;

import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.service.AppUserService;
import by.academy.it.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfileController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/{login}/profile.html")
    public ModelAndView showUserProfile(@PathVariable String login){
        AppUser user = appUserService.findByLogin(login);
        return new ModelAndView("profile")
                .addObject("addNewUserCommand", new AddNewUserCommand());
    }
}
