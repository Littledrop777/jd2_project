package com.academy.it.service;

import com.academy.it.entity.UserInfo;

public interface UserInfoService {

    void update(UserInfo info);

    void save(UserInfo info);

    UserInfo findByUserId(String userId);
}
