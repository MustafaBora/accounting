package com.mustafabora.accounting.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String customerID) {
        super("Customer Not Found With Id: " + customerID);
    }
}
