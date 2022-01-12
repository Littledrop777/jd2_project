package by.academy.it.dao;

import by.academy.it.entity.AppUser;

public interface AppUserDao extends Dao<AppUser, String>{

    AppUser findByLogin(String login);
}
