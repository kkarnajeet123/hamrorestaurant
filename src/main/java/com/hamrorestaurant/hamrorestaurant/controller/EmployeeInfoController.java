package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.model.restCall.EmployeeInfo;
import com.hamrorestaurant.hamrorestaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeInfoController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employee")
    public ResponseEntity<EmployeeInfo> employeeList(){

        EmployeeInfo response = service.getAllEmployee();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
