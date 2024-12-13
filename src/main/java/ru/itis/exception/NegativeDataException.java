package ru.itis.exception;

public class NegativeDataException extends RuntimeException {
    public NegativeDataException(String message) {
        super(message);
    }
}
