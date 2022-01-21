package com.academy.it.dao;

import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.entity.AppUser;

public interface AppUserDao extends Dao<AppUser, String> {

    AppUser findByLogin(String login);

    AppUserInfoDto findUserWIthInfoByLogin(String login);
}
