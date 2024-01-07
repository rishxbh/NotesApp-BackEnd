package com.rishabh.noteApp.exceptions;

public class CannotAccessException extends RuntimeException {
    public CannotAccessException(String msg) {
        super(msg);
    }
    public CannotAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
