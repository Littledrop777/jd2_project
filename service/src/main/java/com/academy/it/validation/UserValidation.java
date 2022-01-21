package com.academy.it.validation;

import com.academy.it.dao.AppUserDao;
import com.academy.it.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserValidation implements EntityValidation<AppUser> {

    private static final String USER_WITH_LOGIN_ALREADY_EXIST_MSG = "User with such login already exist";
    private final AppUserDao appUserDao;

    @Autowired
    public UserValidation(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @Override
    public List<String> validate(AppUser user) {
        List<String> errors = new ArrayList<>();
        if (appUserDao.findByLogin(user.getLogin()) != null) {
            errors.add(USER_WITH_LOGIN_ALREADY_EXIST_MSG);
        }
        return errors;
    }
}
