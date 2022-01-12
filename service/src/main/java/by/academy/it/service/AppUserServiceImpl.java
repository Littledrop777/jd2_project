package by.academy.it.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import by.academy.it.dao.AppUserDao;
import by.academy.it.dao.InfoDao;
import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.entity.Info;
import by.academy.it.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static at.favre.lib.crypto.bcrypt.BCrypt.MIN_COST;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private BCrypt.Hasher hasher;
    @Autowired
    private BCrypt.Verifyer verifyer;

    @Override
    public List<String> appUserValidation(AppUser appUser) {
        List<String> errors = new ArrayList<>();
        if (appUser == null) {
            errors.add("User is null");
            return errors;
        }
        if (appUser.getLogin() == null || appUser.getLogin().isEmpty()) {
            errors.add("Login is empty");
        }
        if (appUser.getPassword() == null || appUser.getPassword().isEmpty()) {
            errors.add("Password is empty");
        }
        return errors;
    }

    public List<String> infoValidation(Info info) {
        List<String> errors = new ArrayList<>();
        if (info == null) {
            errors.add("Info is null");
            return errors;
        }
        if (info.getFirstname() == null || info.getFirstname().isEmpty()) {
            errors.add("First name is empty");
        }
        if (info.getEmail() == null || info.getEmail().isEmpty()) {
            errors.add("Email is empty");
        }
        if (info.getBirthday() == null
                || info.getBirthday().isAfter(LocalDate.now())
                || info.getBirthday().isEqual(LocalDate.now())) {
            errors.add("Wrong birthday");
        }
        return errors;
    }

    @Override
    public List<String> addNewUser(AddNewUserCommand command) {
        List<String> errors = new ArrayList<>();

        AppUser user = new AppUser();
        user.setLogin(command.getLogin());
        user.setPassword(command.getPassword());
        user.setRole(Role.USER);

        Info info = new Info();
        info.setFirstname(command.getFirstname());
        info.setLastname(command.getLastname());
        info.setEmail(command.getEmail());
        info.setBirthday(command.getBirthday());
        info.setGender(command.getGender());

        if (!command.getRepeatPassword().equals(command.getPassword())) {
            errors.add("Password and repeated password are different");
        }
        errors.addAll(appUserValidation(user));
        errors.addAll(infoValidation(info));

        if(errors.isEmpty()){
            char[] charsOfPassword = appUser.getPassword().toCharArray();
            String encryptedPassword = hasher.hashToString(MIN_COST, charsOfPassword);
            appUser.setPassword(encryptedPassword);
            appUserDao.save(appUser);
        }
        return errors;
    }

    @Override
    public AppUser save(AppUser user) {
        return appUserDao.save(user);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserDao.findAll();
    }

    @Override
    public AppUser findById(String id) {
        return appUserDao.findById(id);
    }

    @Override
    public void update(AppUser user) {
        appUserDao.update(user);
    }

    @Override
    public void delete(String id) {
        appUserDao.delete(id);
    }
}
