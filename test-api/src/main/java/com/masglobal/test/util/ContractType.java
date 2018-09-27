package com.masglobal.test.util;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public enum ContractType {
    HOURLY("HourlySalaryEmployee"),
    MONTHLY("MonthlySalaryEmployee");

    private String value;

    ContractType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
