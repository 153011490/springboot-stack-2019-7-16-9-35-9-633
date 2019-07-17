package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private List<Employee> employees=Employee.createEmployees();

    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(value = "page",required = false,defaultValue = "-1") int page,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "-1") int pageSize,
                                          @RequestParam(value = "gender",required = false,defaultValue = "null")String gender){
        if(page==-1&&pageSize==-1)return employees;
        return Employee.getEmployees(page,pageSize,gender);
    }

    @GetMapping("/{id}")
    public List<Employee> getEmployee(@PathVariable("id") int id){
        return employees.stream().filter(employee -> employee.getId()==id).collect(Collectors.toList());
    }

    @PostMapping
    public List<Employee> addEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employees;
    }



}
