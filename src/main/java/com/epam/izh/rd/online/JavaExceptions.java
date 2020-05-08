package com.epam.izh.rd.online;


import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.exception.NotAccessException;
import com.epam.izh.rd.online.exception.SimplePasswordException;
import com.epam.izh.rd.online.exception.UserAlreadyRegisteredException;
import com.epam.izh.rd.online.exception.UserNotFoundException;
import com.epam.izh.rd.online.repository.UserRepository;
import com.epam.izh.rd.online.service.AuthenticationService;
import com.epam.izh.rd.online.service.UserService;

public class JavaExceptions {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        AuthenticationService authenticationService = new AuthenticationService(userRepository);



        //1) Необходимо проверять наличие заполнения всех полей сущности User. Если же поле с логином или паролем не
        //     * заполнено или заполнено пустой строкой. Необходимо выбрасывать существующее непроверяемое исключение
        //     * {@link IllegalArgumentException} с текстом "Ошибка в заполнении полей".
//        User userTestOne = new User("login1", "password");
//        User userTestTwo = new User("", "password");
//        User userTestTree = new User();
//        User userTestFore = new User("login4", "");
//
//        userService.register(userTestOne);
//        userService.register(userTestTwo);
//        userService.register(userTestTree);
//        userService.register(userTestFore);
        //2) Необходимо запрещать регистрацию пользователя, если другой пользователь с подобным логином уже
        //     * зарегистрирован. Необходимо в таком случае выбрасывать проверяемое исключение с названием UserAlreadyRegisteredException
        //     * и текстом - "Пользователь с логином 'login' уже зарегистрирован", где login - логин пользователя.
        //     * <p>


//        User userTestOne = new User("login1", "password");
//        User userTestTwo = new User("login2", "password");
//        User userTestTree = new User("login1", "password");
//        try {
//            userService.register(userTestOne);
//            userService.register(userTestTwo);
//            userService.register(userTestTree);
//        } catch (UserAlreadyRegisteredException e) {
//            e.printStackTrace();
//        }

        //3) Необходимо запрещать регистрацию пользователя, если он пытается установить пароль состоящий из цифр.
        //     * В случае, если это происходит (например пароль = "123432") необходимо выбрасывать
        //     * исключение с названием SimplePasswordException и текстом - "Пароль не соответствует требованиям безопасности"

//        User userTestOne = new User("login1", "password");
//        User userTestTwo = new User("login2", "123432");
//        User userTestTree = new User("login3", "123password123");
//        User userTestFore = new User("login4", "pass134word");
//        try {
//            userService.register(userTestOne);
//            userService.register(userTestTwo);
//            userService.register(userTestTree);
//            userService.register(userTestFore);
//        } catch (UserAlreadyRegisteredException e) {
//            e.printStackTrace();
//        } catch (SimplePasswordException e) {
//            e.printStackTrace();
//        }

        //Если мы попытаемся вызвать метод удаления {@link UserRepository#deleteByLogin(String)}
        //     * пользователем не админом (считаем, что админ имеет логин Admin), то будет выброшено исключение
        //     * {@link UnsupportedOperationException} из репозитория.
//        User userTestOne = new User("login1", "password");
//        User userTestTwo = new User("login2", "password");
//        User userTestTree = new User("login3", "123password123");
//        User userTestFore = new User("login4", "pass134word");
//        try {
//            userService.register(userTestOne);
//            userService.register(userTestTwo);
//            userService.register(userTestTree);
//            userService.register(userTestFore);
//        } catch (UserAlreadyRegisteredException e) {
//            e.printStackTrace();
//        } catch (SimplePasswordException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            userService.delete("Admin");
//            userService.delete("login1");
//            userService.delete("login2");
//        } catch (NotAccessException e) {
//            e.printStackTrace();
//        }

        User userTestOne = new User("login1", "password");
        User userTestTwo = new User("login2", "password");
        try {
            userService.register(userTestOne);
        } catch (UserAlreadyRegisteredException e) {
            e.printStackTrace();
        } catch (SimplePasswordException e) {
            e.printStackTrace();
        }
        try {
            authenticationService.login(userTestOne);
            authenticationService.login(userTestTwo);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }


    }

}
