package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.User;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {

    private static final User userWithoutName = new User("", "qwerty");
    private static final User userWithoutPassword = new User("SuperLogin", "");
    private static final User user = new User("SuperLogin", "qwerty");
    private static final User userWithNumberPassword = new User("Login123", "123");
    private static final User adminUser = new User("Admin", "fd09423kj314fkasl");

    private Providers() {

    }

    public static User getUser() {
        return user;
    }

    public static User getUserWithNumberPassword() {
        return userWithNumberPassword;
    }

    public static User getAdminUser() {
        return adminUser;
    }


    public static Stream<Arguments> testRegisterCase1() {
        return Stream.of(
                arguments(userWithoutName),
                arguments(userWithoutPassword)
        );
    }

    public static Stream<Arguments> testDelete() {
        return Stream.of(
                arguments(user),
                arguments(userWithNumberPassword)
        );
    }
}
