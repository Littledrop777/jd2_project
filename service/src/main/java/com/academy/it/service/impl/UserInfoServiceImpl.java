package com.academy.it.service.impl;

import com.academy.it.dao.UserInfoDao;
import com.academy.it.entity.UserInfo;
import com.academy.it.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoDao infoDao;

    @Autowired
    public UserInfoServiceImpl(UserInfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @Override
    public void update(UserInfo info) {
        info.setUpdateDate(Instant.now());
        infoDao.update(info);
    }

    @Override
    public void save(UserInfo info) {
        infoDao.save(info);
    }

    @Override
    public UserInfo findByUserId(String userId) {
        return infoDao.findByUserId(userId);
    }
}
