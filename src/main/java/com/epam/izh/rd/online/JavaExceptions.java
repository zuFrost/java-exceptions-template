package com.epam.izh.rd.online;


import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.repository.IUserRepository;
import com.epam.izh.rd.online.repository.UserRepository;
import com.epam.izh.rd.online.service.AuthenticationService;
import com.epam.izh.rd.online.service.UserService;

/**
 * В данном классе проверяется корректность реализованных вами методов.
 * Текст для проверки уже задан.
 * <p>
 * Результаты работы методов будут проверены с ответами.
 * Если метод реализован неверно, в консоль будет выведена ошибка.
 */
public class JavaExceptions {

    public static void main(String[] args) {
        boolean practiseMadeCorrectly = true;

        String exceptionClassName;
        String exceptionMessage;
        String correctExceptionClassName;
        String correctExceptionMessage;

        // ------- Проверка функционала регистрации ------- //

        IUserRepository userRepository = new UserRepository();

        UserService userService = new UserService(userRepository);

        // ------- Проверка пользовательского сценария не полного заполнения данных регистрации ------- //

        try {
            User user = new User("AlexWithEmptyPassword", "");
            userService.register(user);

            System.out.println(
                    "Метод register работает неверно. Не было выброшено исключение IllegalArgumentException при " +
                            "регистрации пользователя с пустым паролем.");
            practiseMadeCorrectly = false;
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            correctExceptionMessage = "Ошибка в заполнении полей";

            if (!exceptionMessage.equals(correctExceptionMessage)) {
                System.out.println(String.format(
                        "Метод register работает неверно. Текущее значение сообщения в исключении = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionMessage, correctExceptionMessage));
                practiseMadeCorrectly = false;
            }

            exceptionClassName = exception.getClass().getSimpleName();
            correctExceptionClassName = "IllegalArgumentException";

            if (!exceptionClassName.equals(correctExceptionClassName)) {
                System.out.println(
                        String.format("Метод register работает неверно. Текущее название класса исключения = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionClassName, correctExceptionClassName));
                practiseMadeCorrectly = false;
            }
        }

        // ------- Проверка пользовательского сценария повторной регистрации с тем же логином ------- //

        try {
            User user = new User("IvanTryRegisterTwice", "QXC1_432");

            userService.register(user);
            userService.register(user);

            System.out.println(
                    "Метод register работает неверно. Не было выброшено исключение UserAlreadyRegisteredException при " +
                            "повторной регистрации пользователя с тем же логином.");
            practiseMadeCorrectly = false;

        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            correctExceptionMessage = "Пользователь с логином 'IvanTryRegisterTwice' уже зарегистрирован";

            if (!exceptionMessage.equals(correctExceptionMessage)) {
                System.out.println(String.format(
                        "Метод register работает неверно. Текущее значение сообщения в исключении = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionMessage, correctExceptionMessage));
                practiseMadeCorrectly = false;
            }

            exceptionClassName = exception.getClass().getSimpleName();
            correctExceptionClassName = "UserAlreadyRegisteredException";

            if (!exceptionClassName.equals(correctExceptionClassName)) {
                System.out.println(
                        String.format("Метод register работает неверно. Текущее название класса исключения = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionClassName, correctExceptionClassName));
                practiseMadeCorrectly = false;
            }
        }

        // ------- Проверка пользовательского сценария регистрации с паролем состоящим только из цифр ------- //

        try {
            User user = new User("AlexWithDigitsPassword", "12345");
            userService.register(user);

            System.out.println(
                    "Метод register работает неверно. Не было выброшено исключение SimplePasswordException при " +
                            "регистрации пользователя с паролем состоящим только из цифр.");
            practiseMadeCorrectly = false;
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            correctExceptionMessage = "Пароль не соответствует требованиям безопасности";

            if (!exceptionMessage.equals(correctExceptionMessage)) {
                System.out.println(String.format(
                        "Метод register работает неверно. Текущее значение сообщения в исключении = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionMessage, correctExceptionMessage));
                practiseMadeCorrectly = false;
            }

            exceptionClassName = exception.getClass().getSimpleName();
            correctExceptionClassName = "SimplePasswordException";

            if (!exceptionClassName.equals(correctExceptionClassName)) {
                System.out.println(
                        String.format("Метод register работает неверно. Текущее название класса исключения = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionClassName, correctExceptionClassName));
                practiseMadeCorrectly = false;
            }
        }

        // ------- Проверка функционала авторизации ------- //

        AuthenticationService authenticationService = new AuthenticationService(userRepository);

        // ------- Проверка функционала авторизации пользователем, которого нет в базе данных ----- //

        try {
            User user = new User("VladimirNotRegistered", "QWERTY");
            authenticationService.login(user);

            System.out.println(
                    "Метод login работает неверно. Не было выброшено исключение UserNotFoundException при " +
                            "авторизации пользователя, которого нет в базе данных.");
            practiseMadeCorrectly = false;
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            correctExceptionMessage = "Пользователь с таким логином не найден";

            if (!exceptionMessage.equals(correctExceptionMessage)) {
                System.out.println(String.format(
                        "Метод login работает неверно. Текущее значение сообщения в исключении = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionMessage, correctExceptionMessage));
                practiseMadeCorrectly = false;
            }

            exceptionClassName = exception.getClass().getSimpleName();
            correctExceptionClassName = "UserNotFoundException";

            if (!exceptionClassName.equals(correctExceptionClassName)) {
                System.out.println(
                        String.format("Метод login работает неверно. Текущее название класса исключения = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionClassName, correctExceptionClassName));
                practiseMadeCorrectly = false;
            }
        }

        // ------- Проверка функционала авторизации пользователем, который есть в базе, но с неверным паролем  ----- //

        try {
            User vladimirLostPasswordUser = new User("VladimirLostPasswordUser", "QWERTY");

            /* Зарегистрировали пользователя */
            userService.register(vladimirLostPasswordUser);

            vladimirLostPasswordUser = new User("VladimirLostPasswordUser", "ASDFGHDSDASDSADSDADSAS");

            /* Пытаемся авторизоваться, но с другим паролем */
            authenticationService.login(vladimirLostPasswordUser);

            System.out.println(
                    "Метод login работает неверно. Не было выброшено исключение NotCorrectPasswordException при " +
                            "авторизации пользователя, который ввел неверный пароль.");
            practiseMadeCorrectly = false;
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            correctExceptionMessage = "Пароль введен неверно!";

            if (!exceptionMessage.equals(correctExceptionMessage)) {
                System.out.println(String.format(
                        "Метод login работает неверно. Текущее значение сообщения в исключении = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionMessage, correctExceptionMessage));
                practiseMadeCorrectly = false;
            }

            exceptionClassName = exception.getClass().getSimpleName();
            correctExceptionClassName = "NotCorrectPasswordException";

            if (!exceptionClassName.equals(correctExceptionClassName)) {
                System.out.println(
                        String.format("Метод login работает неверно. Текущее название класса исключения = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionClassName, correctExceptionClassName));
                practiseMadeCorrectly = false;
            }
        }

        // ------- Проверка функционала удаления пользователя другим пользователем (не админом)  ----- //

        try {
            User simpleUser = new User("SimpleUser", "QWERTY");

            /* Зарегистрировали пользователя */
            userService.register(simpleUser);

            User notAdminUser = new User("NotAdminUser", "QWERTY");

            /* Зарегистрировали пользователя */
            userService.register(notAdminUser);

            /* Авторизуемся под пользователем NotAdminUser*/
            authenticationService.login(notAdminUser);

            userService.delete("SimpleUser");

            System.out.println(
                    "Метод delete работает неверно. Не было выброшено исключение NotAccessException при " +
                            "попытке удалить другого пользователя пользователем не админом.");
            practiseMadeCorrectly = false;
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            correctExceptionMessage = "Недостаточно прав для выполнения операции";

            if (!exceptionMessage.equals(correctExceptionMessage)) {
                System.out.println(String.format(
                        "Метод login работает неверно. Текущее значение сообщения в исключении = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionMessage, correctExceptionMessage));
                practiseMadeCorrectly = false;
            }

            exceptionClassName = exception.getClass().getSimpleName();
            correctExceptionClassName = "NotAccessException";

            if (!exceptionClassName.equals(correctExceptionClassName)) {
                System.out.println(
                        String.format("Метод login работает неверно. Текущее название класса исключения = '%s'. " +
                                "Ожидаемое значение = '%s'.", exceptionClassName, correctExceptionClassName));
                practiseMadeCorrectly = false;
            }
        }

        // ------- Проверка функционала удаления пользователя другим пользователем (админом)  ----- //

        try {
            User simpleUserToDeleteByAdmin = new User("SimpleUserToDeleteByAdmin", "QWERTY");

            /* Зарегистрировали пользователя */
            userService.register(simpleUserToDeleteByAdmin);

            User admin = new User("Admin", "QWERTY");

            /* Зарегистрировали пользователя админа */
            userService.register(admin);

            /* Авторизуемся под пользователем админом*/
            authenticationService.login(admin);

            userService.delete("SimpleUserToDeleteByAdmin");

        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
            exceptionClassName = exception.getClass().getSimpleName();

            System.out.println(String.format(
                    "Метод delete работает неверно. Было выброшего исключение = '%s' с текстом = '%s' при попытке " +
                            "удаления другого пользователя админом.", exceptionClassName, exceptionMessage));
            practiseMadeCorrectly = false;
        }

        if (practiseMadeCorrectly) {
            System.out.println("Практика сделана верно");
        } else {
            System.out.println("Практика сделана неверно");
        }
    }

}
