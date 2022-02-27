package com.academy.it.validation;

import com.academy.it.dao.UserInfoDao;
import com.academy.it.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoValidation implements EntityValidation<UserInfo> {

    private static final String USER_WITH_EMAIL_ALREADY_EXIST_MSG = "User with such email already exist";
    private final UserInfoDao userInfoDao;

    @Autowired
    public InfoValidation(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public List<String> validate(UserInfo info) {
        List<String> errors = new ArrayList<>();
        if (!info.getEmail().isEmpty() && userInfoDao.findByEmail(info.getEmail()) != null) {
            errors.add(USER_WITH_EMAIL_ALREADY_EXIST_MSG);
        }
        return errors;
    }
}
