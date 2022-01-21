package by.academy.it.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import by.academy.it.dao.AppUserDao;
import by.academy.it.dao.UserInfoDao;
import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.dto.LoginUserCommand;
import by.academy.it.entity.AppUser;
import by.academy.it.entity.Role;
import by.academy.it.entity.UserInfo;
import by.academy.it.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static at.favre.lib.crypto.bcrypt.BCrypt.MIN_COST;
import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    public static final String USER_WITH_LOGIN_ALREADY_EXIST_MSG = "User with such login already exist";
    public static final String USER_WITH_EMAIL_ALREADY_EXIST_MSG = "User with such email already exist";

    private final AppUserDao appUserDao;
    private final UserInfoDao infoDao;
    private final BCrypt.Hasher hasher;
    private final BCrypt.Verifyer verifyer;

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
        }
        return errors;
    }
        @Override
        @Transactional
        public List<String> addNewUser (AddNewUserCommand command){
            UserInfo info = UserInfo.builder()
                    .firstname(command.getFirstname())
                    .lastname(command.getLastname())
                    .email(command.getEmail())
                    .birthday(command.getBirthday())
                    .gender(command.getGender())
                    .createDate(Instant.now())
                    .build();

            AppUser user = new AppUser();
            user.setLogin(command.getLogin());
            user.setPassword(command.getPassword());
            user.setRole(Role.USER);
            user.setUserInfo(info);

            List<String> errors = validateUser(user);
            errors.addAll(validateInfo(info));
            if (errors.isEmpty()) {
                this.save(user);
            }
            return errors;
        }

        private List<String> validateUser (AppUser user){
            List<String> errors = new ArrayList<>();
            if (appUserDao.findByLogin(user.getLogin()) != null) {
                errors.add(USER_WITH_LOGIN_ALREADY_EXIST_MSG);
            }
            return errors;
        }

        private List<String> validateInfo (UserInfo info){
            List<String> errors = new ArrayList<>();
            if (infoDao.findByEmail(info.getEmail()) != null) {
                errors.add(USER_WITH_EMAIL_ALREADY_EXIST_MSG);
            }
            return errors;
        }

        @Override
        public AppUser findByLogin (String login){
            return appUserDao.findByLogin(login);
        }

        @Override
        public AppUser save (AppUser user){
            char[] charsOfPassword = user.getPassword().toCharArray();
            String encryptedPassword = hasher.hashToString(MIN_COST, charsOfPassword);
            user.setPassword(encryptedPassword);
            return appUserDao.save(user);
        }

        @Override
        public List<AppUser> findAll () {
            return appUserDao.findAll();
        }

        @Override
        public AppUser findById (String id){
            return appUserDao.findById(id);
        }

        @Override
        public void update (AppUser user){
            appUserDao.update(user);
        }

        @Override
        public void delete (String id){
            appUserDao.delete(id);
        }
    }
