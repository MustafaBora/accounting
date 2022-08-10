package com.mustafabora.accounting.aop;

import com.mustafabora.accounting.exception.ServiceNotUpException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceNotUpAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    String serviceUnavaliableHandler(ServiceNotUpException ex) {
        return ex.getMessage();
    }
}
