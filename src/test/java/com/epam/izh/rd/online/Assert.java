package com.epam.izh.rd.online;

import lombok.SneakyThrows;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Assert<T extends Throwable> {

    public T assertThrowsWithClassName(String className, Executable executable, String message) {
        return assertThrows(forName(className), executable, message);
    }

    @SneakyThrows
    private Class<T> forName(String className) {
        return (Class<T>) Class.forName("com.epam.izh.rd.online.exception." + className);
    }
}
