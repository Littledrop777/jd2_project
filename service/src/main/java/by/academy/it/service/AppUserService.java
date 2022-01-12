package by.academy.it.service;

import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.entity.AppUser;

import java.util.List;

public interface AppUserService extends AppService<AppUser, String>{

    List<String> appUserValidation(AppUser appUser);

    List<String> addNewUser(AddNewUserCommand command);
}
