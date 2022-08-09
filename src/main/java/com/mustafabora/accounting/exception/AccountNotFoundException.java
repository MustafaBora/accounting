package com.mustafabora.accounting.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String accountId) {
        super("Account Not Found With Id: " + accountId);
    }
}
