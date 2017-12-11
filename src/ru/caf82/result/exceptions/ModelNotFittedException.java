package ru.caf82.result.exceptions;

public class ModelNotFittedException extends Exception {
    ModelNotFittedException() {
        super();
    }
    ModelNotFittedException(String message) {
        super(message);
    }
    ModelNotFittedException(Throwable cause) {
        super(cause);
    }
    ModelNotFittedException(Throwable cause, String message) {
        super(message);
    }
}
