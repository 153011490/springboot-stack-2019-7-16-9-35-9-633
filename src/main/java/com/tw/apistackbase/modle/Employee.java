package com.tw.apistackbase.modle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double salary;

    private static List<Employee> employees=new ArrayList<>();

    public static List<Employee> createEmployees(){
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

    public static List<Employee> getEmployees(int page,int pageSize,String gender){
        if(page<=0||pageSize<=0)return null;
        List<Employee> employeeList=new ArrayList<>();
        if(page*pageSize>employees.size()){
            for (int i = (page-1)*pageSize; i < employees.size(); i++) {
                employeeList.add(employees.get(i));
            }
        }else{
            for (int i = (page-1)*pageSize; i < page*pageSize; i++) {
                employeeList.add(employees.get(i));
            }
        }
        if(!gender.equals("null")){
           return employees.stream().filter(employee -> employee.getGender()==gender).collect(Collectors.toList());
        }
        return employeeList;
    }
    
    public static List<Employee> updateEmployee(int id,Employee employee){
        return employees.stream().map(item->item.getId()==id?employee:item).collect(Collectors.toList());
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

