package com.masglobal.test.service;

import com.masglobal.test.contract.Employee;
import java.util.List;

/**
 * Created by angelquiroz on 9/26/18 .
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getOneEmployee(String id);
}
