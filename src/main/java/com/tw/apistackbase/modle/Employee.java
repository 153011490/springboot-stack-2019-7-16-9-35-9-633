package com.tw.apistackbase.modle;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double salary;

    public static List<Employee> createEmployees(){
        List<Employee> employees=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            Employee employee=new Employee();
            employee.setId(i);
            employee.setName("employee"+i);
            employee.setAge(i);
            employee.setGender("Female");
            employee.setSalary(5000*i);
            employees.add(employee);
        }
        return employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

