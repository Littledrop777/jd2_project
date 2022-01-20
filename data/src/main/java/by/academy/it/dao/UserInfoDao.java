package by.academy.it.dao;

import by.academy.it.entity.UserInfo;

public interface UserInfoDao extends Dao<UserInfo, String> {

    UserInfo findByEmail(String email);
}

