package com.masglobal.test.contract;

import java.math.BigDecimal;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public class HourlyContractEmployee extends Employee {

    public HourlyContractEmployee(int id, String name, String contractTypeName, int roleId, String roleName,
            String roleDescription, BigDecimal hourlySalary, BigDecimal monthlySalary) {
        super(id, name, contractTypeName, roleId, roleName, roleDescription, hourlySalary, monthlySalary);
    }

    @Override public void calculateAnnualSalary() {
        setAnnualSalary(getHourlySalary().multiply(new BigDecimal("120")).multiply(new BigDecimal("12")) );
    }
}
