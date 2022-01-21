package com.academy.it.service;

import com.academy.it.dto.AddNewUserDto;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.dto.LoginUserDto;
import com.academy.it.entity.AppUser;

import java.util.List;

public interface AppUserService {

    List<String> addNewUser(AddNewUserDto command);

    List<String> loginUser(LoginUserDto loginUserDto);

    AppUserInfoDto findUserWIthInfoByLogin(String login);

    AppUser findByLogin(String login);

    AppUser save(AppUser user);

    List<AppUser> findAll();

    AppUser findById(String id);

    void update(AppUser appUser);

    void delete(String id);

}
