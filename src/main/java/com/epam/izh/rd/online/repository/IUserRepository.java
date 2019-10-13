package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.User;

public interface IUserRepository {

    User save(User user);

    User findByLogin(String login);

    void deleteByLogin(String login);
}
