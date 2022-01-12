package by.academy.it.validation;

import by.academy.it.entity.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserValidation {

    public List<String> userDataValidation(AppUser user) {
        List<String> errors = new ArrayList<>();
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            errors.add("Login is empty");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            errors.add("Password is empty");
        }
        return errors;
    }
}
