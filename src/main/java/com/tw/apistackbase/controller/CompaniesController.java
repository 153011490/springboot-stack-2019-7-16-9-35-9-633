package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private List<Company> companies=Company.createComponiess();

    @GetMapping
    public List<Company> getAllCompany(@RequestParam(value = "page",required = false,defaultValue = "-1") int page,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "-1") int pageSize){
        if(page==-1&&pageSize==-1)return companies;
        return Company.getCompaniesByPage(page,pageSize);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id") int id ){
        return Company.getComponyById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployessByCompanyId(@PathVariable("id") int id){
        return Company.getEmployessByCompanyId(id);
    }

}
