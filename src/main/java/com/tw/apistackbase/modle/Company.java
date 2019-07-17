package com.tw.apistackbase.modle;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {

    private int id;
    private String name;

    private List<Employee> employees;

    public static List<Company> companies=new ArrayList<>();

    public static List<Company> createComponiess(){
        companies.clear();
        for (int i = 0; i <3 ; i++) {
            Company company=new Company();
            company.id=i+1;
            company.name="company"+i;
            company.employees=Employee.createEmployees();
            companies.add(company);
        }
        return companies;
    }

    public static Company getComponyById(int id){
        createComponiess();
        return companies.stream().filter(item->item.getId()==id).collect(Collectors.toList()).get(0);
    }

    public static List<Employee> getEmployessByCompanyId(int id){
        createComponiess();
        return companies.stream().filter(item->item.getId()==id).collect(Collectors.toList()).get(0).getEmployees();
    }

    public static List<Company> getCompaniesByPage(int page, int pageSize) {
        List<Company> companyList=new ArrayList<>();
        if(page*pageSize>companies.size()){
            for (int i = (page-1)*pageSize; i < companies.size(); i++) {
                companyList.add(companies.get(i));
            }
        }else{
            for (int i = (page-1)*pageSize; i < page*pageSize; i++) {
                companyList.add(companies.get(i));
            }
        }
        return companyList;
    }

    public static void updateCompany(int id,Company company){
        createComponiess();
        companies=companies.stream().map(item->item.getId()==id?company:item).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
