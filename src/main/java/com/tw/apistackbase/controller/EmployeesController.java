package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private List<Employee> employees=Employee.createEmployees();

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employees;
    }

    @GetMapping("/{id}")
    public List<Employee> getEmployee(@PathVariable("id") int id){
        return employees.stream().filter(employee -> employee.getId()==id).collect(Collectors.toList());
    }

}
