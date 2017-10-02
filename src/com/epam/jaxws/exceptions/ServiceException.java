package com.epam.jaxws.exceptions;

/**
 * Created by Mikhail_Kiarko on 12/28/2016.
 */
public class ServiceException extends Exception {
    public ServiceException(){}
    public ServiceException(String message, Throwable exception) {
        super(message, exception);
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Throwable exception) {
        super(exception);
    }
}
