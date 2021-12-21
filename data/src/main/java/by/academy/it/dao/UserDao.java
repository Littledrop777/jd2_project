package by.academy.it.dao;

import by.academy.it.model.User;

import java.util.Optional;

public interface UserDao extends Dao<User>{

    Optional<User> findByLogin(String login);
}
