package com.academy.it.service;

import com.academy.it.dto.AddNewUserDto;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.dto.LoginUserDto;
import com.academy.it.dto.UpdateUserDto;
import com.academy.it.entity.AppUser;

import java.util.List;

public interface AppUserService {

    List<String> addNewUser(AddNewUserDto command);

    List<String> loginUser(LoginUserDto loginUserDto);

    AppUserInfoDto findUserWIthInfoById(String id);

    AppUser findByLogin(String login);

    AppUser findById(String id);

    void updateUser(UpdateUserDto userDto, String userId);

    void save(AppUser user);

    void update(AppUser user);

    void delete(String id);
}
