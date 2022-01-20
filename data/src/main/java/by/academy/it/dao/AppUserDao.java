package by.academy.it.dao;

import by.academy.it.entity.AppUser;

<<<<<<< HEAD
public interface AppUserDao extends Dao<AppUser, String> {
=======
public interface AppUserDao extends Dao<AppUser, String>{
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614

    AppUser findByLogin(String login);
}
