package by.academy.it.service;

import by.academy.it.dto.AddNewUserCommand;
<<<<<<< HEAD
import by.academy.it.dto.LoginUserCommand;
=======
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
import by.academy.it.entity.AppUser;

import java.util.List;

<<<<<<< HEAD
public interface AppUserService {

    List<String> addNewUser(AddNewUserCommand command);

    List<String> loginUser(LoginUserCommand loginUserCommand);

    AppUser findByLogin(String login);

    AppUser save(AppUser user);

    List<AppUser> findAll();

    AppUser findById(String id);

    void update(AppUser appUser);

    void delete(String id);
=======
public interface AppUserService extends AppService<AppUser, String>{

    List<String> appUserValidation(AppUser appUser);

    List<String> addNewUser(AddNewUserCommand command);
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
}
