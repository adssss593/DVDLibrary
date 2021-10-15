package com.aj.dvd.servicelayer;

public class DaoValidationException extends Exception{

    public DaoValidationException(String message) {
        super(message);
    }

    public DaoValidationException(String message, Throwable cause){
        super(message, cause);
    }
}
