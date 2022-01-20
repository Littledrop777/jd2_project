package by.academy.it.controller;

import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    @Qualifier("appUserServiceImpl")
    private AppUserService userService;

    @GetMapping("/registration.html")
    public ModelAndView registrationView() {
        return new ModelAndView("registration")
                .addObject("addNewUserCommand", new AddNewUserCommand());
    }


    @PostMapping("/registration-new-user.do")
    public ModelAndView registrationNewUser(@ModelAttribute("addNewUserCommand")
                                            @Valid AddNewUserCommand addNewUserCommand,
                                            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("registration")
                    .addObject("error", result.getAllErrors().get(0).getDefaultMessage());

        }
        List<String> errors = userService.addNewUser(addNewUserCommand);
        if (!errors.isEmpty()) {
            return new ModelAndView("registration").addObject("error", errors.get(0));
        }
        return new ModelAndView("redirect:" + addNewUserCommand.getLogin() + "/profile.html");
    }
}
