package com.thewhite.sstuapp.web.rest.exception;

/**
 * Created by tupichkindenis on 24.08.17.
 */
@SuppressWarnings("unused")
public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException() {
        super();
    }
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
