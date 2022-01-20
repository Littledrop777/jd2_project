package by.academy.it.controller;

import by.academy.it.dto.LoginUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("currentUser")
public class LoginController {

    private AppUserService appUserService;

    @Autowired
    public LoginController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(path = {"/", "/login.html"})
    public ModelAndView home() {
        return new ModelAndView("login")
                .addObject("loginUserCommand", new LoginUserCommand());

    }

    @PostMapping("/login-user.do")
    public ModelAndView addNewUser(@ModelAttribute("loginUserCommand")
                                   @Valid LoginUserCommand loginUserCommand,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("login")
                    .addObject("error", result.getAllErrors().get(0).getDefaultMessage());
        }
        List<String> errors = appUserService.loginUser(loginUserCommand);
        if (!errors.isEmpty()) {
            return new ModelAndView("login")
                    .addObject("error", errors.get(0));
        }
        AppUser currentUser = appUserService.findByLogin(loginUserCommand.getLogin());
        return new ModelAndView("redirect:" + currentUser.getLogin()+ "/profile.html");
    }

}
