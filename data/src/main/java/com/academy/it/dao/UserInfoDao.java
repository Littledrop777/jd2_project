package com.academy.it.dao;

import com.academy.it.entity.UserInfo;

public interface UserInfoDao extends Dao<UserInfo, String> {

    UserInfo findByEmail(String email);
}

