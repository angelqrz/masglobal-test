package com.masglobal.test.contract;

import com.masglobal.test.remote.EmployeeRemoteResponse;
import com.masglobal.test.util.ContractType;
import java.math.BigDecimal;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public class EmployeeFactory {
    public static Employee getEmployee(int id, String name, String contractTypeName, int roleId, String roleName,
            String roleDescription, BigDecimal hourlySalary, BigDecimal monthlySalary) {
        if (ContractType.HOURLY.getValue().equals(contractTypeName)) {
            return new MonthlyContractEmployee(id, name, contractTypeName, roleId, roleName, roleDescription,
                    hourlySalary, monthlySalary);
        } else if (ContractType.MONTHLY.getValue().equals(contractTypeName)) {
            return new HourlyContractEmployee(id, name, contractTypeName, roleId, roleName, roleDescription,
                    hourlySalary, monthlySalary);
        }
        return null;
    }

    public static Employee getEmployee(EmployeeRemoteResponse employeeResponse) {
        if (ContractType.HOURLY.getValue().equals(employeeResponse.getContractTypeName())) {
            return new HourlyContractEmployee(employeeResponse.getId(), employeeResponse.getName(),
                    employeeResponse.getContractTypeName(), employeeResponse.getRoleId(),
                    employeeResponse.getRoleName(), employeeResponse.getRoleDescription(),
                    employeeResponse.getHourlySalary(),
                    employeeResponse.getMonthlySalary());
        } else if (ContractType.MONTHLY.getValue().equals(employeeResponse.getContractTypeName())) {
            return new MonthlyContractEmployee(employeeResponse.getId(), employeeResponse.getName(),
                    employeeResponse.getContractTypeName(), employeeResponse.getRoleId(),
                    employeeResponse.getRoleName(), employeeResponse.getRoleDescription(),
                    employeeResponse.getHourlySalary(),
                    employeeResponse.getMonthlySalary());
        }
        return null;
    }
}
