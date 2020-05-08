package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.exception.SimplePasswordException;
import com.epam.izh.rd.online.exception.UserAlreadyRegisteredException;

public interface IUserService {

    User register(User user) throws UserAlreadyRegisteredException, SimplePasswordException;

    void delete(String login);
}
