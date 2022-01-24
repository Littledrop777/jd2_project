package com.academy.it.controller;

import com.academy.it.dto.AddNewUserDto;
import com.academy.it.entity.AppUser;
import com.academy.it.service.AppUserService;
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
public class RegistrationController {

    private final AppUserService userService;

    @Autowired
    public RegistrationController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration.html")
    public ModelAndView registrationView() {
        return new ModelAndView("registration")
                .addObject("addNewUserDto", new AddNewUserDto());
    }

    @PostMapping("/registration-new-user.do")
    public ModelAndView registrationNewUser(@ModelAttribute("addNewUserDto")
                                            @Valid AddNewUserDto addNewUserDto,
                                            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("registration")
                    .addObject("error", result.getAllErrors().get(0).getDefaultMessage());
        }
        List<String> errors = userService.addNewUser(addNewUserDto);
        if (!errors.isEmpty()) {
            return new ModelAndView("registration")
                    .addObject("error", errors.get(0));
        }
        AppUser currentUser = userService.findByLogin(addNewUserDto.getLogin());
        return new ModelAndView("redirect:" + currentUser.getId() + "/profile.html")
                .addObject("currentUser", currentUser);
    }
}
