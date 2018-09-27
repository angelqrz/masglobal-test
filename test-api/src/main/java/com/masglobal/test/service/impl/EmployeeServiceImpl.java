package com.masglobal.test.service.impl;

import com.masglobal.test.contract.Employee;
import com.masglobal.test.contract.EmployeeFactory;
import com.masglobal.test.exception.EmployeeNotFoundException;
import com.masglobal.test.remote.EmployeeRemoteResponse;
import com.masglobal.test.remote.EmployeeRemoteService;
import com.masglobal.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by angelquiroz on 9/26/18 .
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @Override public List<Employee> getAllEmployees() {
        List<EmployeeRemoteResponse> employessRaw = employeeRemoteService.getEmployees();
        return employessRaw.stream().map(EmployeeFactory::getEmployee).collect(Collectors.toList());
    }

    @Override public Employee getOneEmployee(String id) {
        List<EmployeeRemoteResponse> employessRaw = employeeRemoteService.getEmployees();
        try {
            return EmployeeFactory.getEmployee(
                    employessRaw.stream().filter(employee -> employee.getId() == Integer.parseInt(id)).findFirst()
                            .orElseThrow(
                                    () -> new EmployeeNotFoundException(404, "Employee with id: " + id + " not found")));
        }catch (NumberFormatException e){
            throw new EmployeeNotFoundException(500, "Employee not found, error in Id format");
        }
    }
}
