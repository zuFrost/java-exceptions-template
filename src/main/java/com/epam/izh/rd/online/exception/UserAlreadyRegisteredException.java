package com.epam.izh.rd.online.exception;

public class UserAlreadyRegisteredException extends Exception {

    public UserAlreadyRegisteredException() {
    }

    public UserAlreadyRegisteredException(String message) {
        super(message);
    }

    public UserAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }
}
