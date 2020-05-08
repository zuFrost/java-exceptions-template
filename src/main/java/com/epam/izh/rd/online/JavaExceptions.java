package com.epam.izh.rd.online;


import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.repository.UserRepository;
import com.epam.izh.rd.online.service.UserService;

public class JavaExceptions {

    public static void main(String[] args) {
        User userTestOne = new User("login1", "password");
        User userTestTwo = new User("", "password");
        User userTestTree = new User();
        User userTestFore = new User("login4", "");


        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        userService.register(userTestOne);
        userService.register(userTestTwo);
        userService.register(userTestTree);
        userService.register(userTestFore);

    }

}
