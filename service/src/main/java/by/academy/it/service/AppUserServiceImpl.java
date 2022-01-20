package by.academy.it.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import by.academy.it.dao.AppUserDao;
<<<<<<< HEAD
import by.academy.it.dao.UserInfoDao;
import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.dto.LoginUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.entity.UserInfo;
=======
import by.academy.it.dao.InfoDao;
import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.entity.Info;
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
import by.academy.it.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
<<<<<<< HEAD
import java.time.Instant;
=======
import java.time.LocalDate;
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
import java.util.ArrayList;
import java.util.List;

import static at.favre.lib.crypto.bcrypt.BCrypt.MIN_COST;
<<<<<<< HEAD
import static java.nio.charset.StandardCharsets.UTF_8;
=======
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

<<<<<<< HEAD
    public static final String USER_WITH_LOGIN_ALREADY_EXIST_MSG = "User with such login already exist";
    public static final String USER_WITH_EMAIL_ALREADY_EXIST_MSG = "User with such email already exist";

    private AppUserDao appUserDao;
    private UserInfoDao infoDao;
    private BCrypt.Hasher hasher;
    private BCrypt.Verifyer verifyer;

    @Autowired
    public AppUserServiceImpl(AppUserDao appUserDao,
                              UserInfoDao infoDao,
                              BCrypt.Hasher hasher,
                              BCrypt.Verifyer verifyer) {
        this.appUserDao = appUserDao;
        this.infoDao = infoDao;
        this.hasher = hasher;
        this.verifyer = verifyer;
    }

    @Override
    public List<String> loginUser(LoginUserCommand loginUserCommand) {
        List<String> errors = new ArrayList<>();
        final byte[] enteredPassword = loginUserCommand.getPassword().getBytes(UTF_8);
        AppUser user = appUserDao.findByLogin(loginUserCommand.getLogin());
        if (user == null) {
            errors.add("Wrong login");
        } else {
            final byte[] encryptedPasswordFromDb = user.getPassword().getBytes(UTF_8);
            if (!verifyer.verify(enteredPassword, encryptedPasswordFromDb).verified) {
                errors.add("Wrong password");
            }
=======
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
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
        }
        return errors;
    }

<<<<<<< HEAD

    @Override
    @Transactional
    public List<String> addNewUser(AddNewUserCommand command) {
        UserInfo info = UserInfo.builder()
                .firstname(command.getFirstname())
                .lastname(command.getLastname())
                .email(command.getEmail())
                .birthday(command.getBirthday())
                .gender(command.getGender())
                .createDate(Instant.now())
                .build();
=======
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
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

        AppUser user = new AppUser();
        user.setLogin(command.getLogin());
        user.setPassword(command.getPassword());
        user.setRole(Role.USER);
<<<<<<< HEAD
        user.setUserInfo(info);

        List<String> errors = validateUser(user);
        errors.addAll(validateInfo(info));
        if(errors.isEmpty()){
            this.save(user);
        }
        return errors;
    }

    private List<String> validateUser(AppUser user) {
        List<String> errors = new ArrayList<>();
        if (appUserDao.findByLogin(user.getLogin()) != null) {
            errors.add(USER_WITH_LOGIN_ALREADY_EXIST_MSG);
            return errors;
        }
        char[] charsOfPassword = user.getPassword().toCharArray();
        String encryptedPassword = hasher.hashToString(MIN_COST, charsOfPassword);
        user.setPassword(encryptedPassword);
        return errors;
    }

    private List<String> validateInfo(UserInfo info) {
        List<String> errors = new ArrayList<>();
        if (infoDao.findByEmail(info.getEmail()) != null) {
            errors.add(USER_WITH_EMAIL_ALREADY_EXIST_MSG);
=======

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
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
        }
        return errors;
    }

    @Override
<<<<<<< HEAD
    public AppUser findByLogin(String login) {
        return appUserDao.findByLogin(login);
    }

    @Override
=======
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
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
<<<<<<< HEAD

=======
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
}
