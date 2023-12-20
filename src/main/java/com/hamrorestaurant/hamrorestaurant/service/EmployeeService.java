package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.model.restCall.EmployeeInfo;

public interface EmployeeService {

    EmployeeInfo getAllEmployee();
    String updateEmployeeInfo(EmployeeInfo employeeInfo, String employeeId);
    String saveEmployeeInfo(EmployeeInfo employeeInfo);
    String deleteEmployeeInfo(String employeeId);
    EmployeeInfo getEmployeeById(String employeeId);
}
