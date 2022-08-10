package com.mustafabora.accounting.exception;

public class ServiceNotUpException extends RuntimeException {
    public ServiceNotUpException(String message) {
        super(message);
    }
}
