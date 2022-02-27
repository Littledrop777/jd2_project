package com.academy.it.dao;

import com.academy.it.dto.AppUserChatDto;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.entity.AppUser;

import java.util.List;

public interface AppUserDao extends Dao<AppUser, String> {

    AppUser findByLogin(String login);

    AppUserInfoDto findUserWIthInfoById(String id);

    List<SearchUserResultDto> findAllByCriteria(String criteria, int first, int max);

    List<AppUserChatDto> findAllByUserChatId(String userChatId, int first, int max);
}
