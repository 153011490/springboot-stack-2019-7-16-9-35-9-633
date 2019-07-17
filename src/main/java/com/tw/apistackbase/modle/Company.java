package com.tw.apistackbase.modle;


import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;

    private List<Employee> employees;

    public static List<Company> companies=new ArrayList<>();

    public static List<Company> createComponiess(){
        companies.clear();
        for (int i = 0; i <3 ; i++) {
            Company company=new Company();
            company.name="company"+i;
            company.employees=Employee.createEmployees();
            companies.add(company);
        }
        return companies;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
