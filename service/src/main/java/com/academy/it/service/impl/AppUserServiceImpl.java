package com.academy.it.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.AddNewUserDto;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.dto.LoginUserDto;
import com.academy.it.entity.AppUser;
import com.academy.it.entity.Role;
import com.academy.it.entity.UserInfo;
import com.academy.it.service.AppUserService;
import com.academy.it.validation.InfoValidation;
import com.academy.it.validation.UserValidation;
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

    private final AppUserDao appUserDao;
    private final BCrypt.Hasher hasher;
    private final BCrypt.Verifyer verifyer;
    private final InfoValidation infoValidation;
    private final UserValidation userValidation;

    @Autowired
    public AppUserServiceImpl(AppUserDao appUserDao,
                              BCrypt.Hasher hasher,
                              BCrypt.Verifyer verifyer,
                              InfoValidation infoValidation,
                              UserValidation userValidation) {
        this.appUserDao = appUserDao;
        this.hasher = hasher;
        this.verifyer = verifyer;
        this.infoValidation = infoValidation;
        this.userValidation = userValidation;
    }

    @Override
    public List<String> loginUser(LoginUserDto loginUserDto) {
        List<String> errors = new ArrayList<>();
        final byte[] enteredPassword = loginUserDto.getPassword().getBytes(UTF_8);
        AppUser user = appUserDao.findByLogin(loginUserDto.getLogin());
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
    public List<String> addNewUser(AddNewUserDto command) {
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

        List<String> errors = userValidation.validate(user);
        errors.addAll(infoValidation.validate(info));
        if (errors.isEmpty()) {
            this.save(user);
        }
        return errors;
    }

    @Override
    @Transactional
    public AppUser save(AppUser user) {
        char[] charsOfPassword = user.getPassword().toCharArray();
        String encryptedPassword = hasher.hashToString(MIN_COST, charsOfPassword);
        user.setPassword(encryptedPassword);
        return appUserDao.save(user);
    }

    @Override
    public AppUserInfoDto findUserWIthInfoByLogin(String login) {
        return appUserDao.findUserWIthInfoByLogin(login);
    }

    @Override
    public AppUser findByLogin(String login) {
        return appUserDao.findByLogin(login);
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
    @Transactional
    public void update(AppUser user) {
        appUserDao.update(user);
    }

    @Override
    @Transactional
    public void delete(String id) {
        appUserDao.delete(id);
    }
}