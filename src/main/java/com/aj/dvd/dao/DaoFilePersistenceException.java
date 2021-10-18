package com.aj.dvd.dao;

public class DaoFilePersistenceException extends Exception{
    public DaoFilePersistenceException(String message) {
        super(message);
    }

    public DaoFilePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
