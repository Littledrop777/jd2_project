package by.academy.it.service;

import by.academy.it.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo findByEmail(String login);

    List<UserInfo> findAll();

    UserInfo findById(String id);

    void update(UserInfo info);

    void delete(String id);
}
