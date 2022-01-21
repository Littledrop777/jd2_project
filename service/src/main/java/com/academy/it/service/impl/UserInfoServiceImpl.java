package com.academy.it.service.impl;

import com.academy.it.dao.UserInfoDao;
import com.academy.it.entity.UserInfo;
import com.academy.it.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoDao userInfoDao;

    @Autowired
    public UserInfoServiceImpl(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfo findByEmail(String email) {
        return userInfoDao.findByEmail(email);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public UserInfo findById(String id) {
        return userInfoDao.findById(id);
    }

    @Override
    public void update(UserInfo info) {
        userInfoDao.update(info);
    }

    @Override
    public void delete(String id) {
        userInfoDao.delete(id);
    }
}
