package com.masglobal.test.exception;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public class EmployeeNotFoundException extends RuntimeException {
    private int code;

    public EmployeeNotFoundException(int code, String message){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
