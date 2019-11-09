package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.repository.IUserRepository;
import com.epam.izh.rd.online.repository.UserRepository;
import com.epam.izh.rd.online.service.AuthenticationService;
import com.epam.izh.rd.online.service.IAuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.epam.izh.rd.online.Providers.getUser;

public class AunthenticationServiceTest {

    private IAuthenticationService authenticationService;
    private IUserRepository userRepository;
    private Assert assertion = new Assert();

    @BeforeEach
    private void setup() {
        userRepository = new UserRepository();
        authenticationService = new AuthenticationService(userRepository);
    }

    @Test
    @DisplayName("Тест метода IAuthenticationService.login(User user)")
    void testRegisterCase1() {
        assertion.assertThrowsWithClassName("UserNotFoundException", () -> authenticationService.login(getUser()),
                "Пользователь с таким логином не найден");
    }

    @Test
    @DisplayName("Тест метода IAuthenticationService.login(User user)")
    void testRegisterCase2() {
        User user = getUser();
        userRepository.save(user);

        assertion.assertThrowsWithClassName("NotCorrectPasswordException", () -> authenticationService.login(user.withWrongPassword()),
                "Пароль введен неверно!");
    }

}
