package com.arrudamoreira.fisioneurapp.services.exceptions;

/**
 *
 * @author marruda
 */
public class CustomValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomValidationException(String msg) {
        super(msg);
    }

    public CustomValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
