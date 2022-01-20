package by.academy.it.service;

import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.dto.LoginUserCommand;
import by.academy.it.entity.AppUser;

import java.util.List;

public interface AppUserService {

    List<String> addNewUser(AddNewUserCommand command);

    List<String> loginUser(LoginUserCommand loginUserCommand);

    AppUser findByLogin(String login);

    AppUser save(AppUser user);

    List<AppUser> findAll();

    AppUser findById(String id);

    void update(AppUser appUser);

    void delete(String id);
}
