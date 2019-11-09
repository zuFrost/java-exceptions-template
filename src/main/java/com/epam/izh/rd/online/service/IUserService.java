package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.User;

public interface IUserService {

    User register(User user);

    void delete(String login);
}
