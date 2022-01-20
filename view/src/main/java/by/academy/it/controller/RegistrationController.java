package by.academy.it.controller;

import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
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
    public ModelAndView registrationNewUser(@ModelAttribute("addNewUserCommand") AddNewUserCommand addNewUserCommand,
                                            BindingResult result) {
        List<String> errors = userService.addNewUser(addNewUserCommand);
        if(!errors.isEmpty()){
            errors.forEach(error -> result.addError(new ObjectError("addNewUserCommand", error)));
            return new ModelAndView("registration");
        }
        return new ModelAndView("redirect:/profile.html");

    }
}
