package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import com.tw.apistackbase.modle.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private List<Company> companies=Company.createComponiess();

    @GetMapping
    public List<Company> getAllCompany(@RequestParam(value = "page",required = false,defaultValue = "-1") int page,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "-1") int pageSize){
        companies=Company.createComponiess();
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

    @PostMapping
    public List<Company> addCompany(@RequestBody Company company){
        companies=Company.createComponiess();
        companies.add(company);
        return companies;
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable("id") int id,@RequestBody Company company){
        Company.updateCompany(id,company);
        return companies.stream().filter(item->item.getId()==id).collect(Collectors.toList()).get(0);
    }

    @DeleteMapping("/{id}")
    public List<Company> deleteCompony(@PathVariable("id") int id) {
        return companies=companies.stream().filter(item->item.getId()!=id).collect(Collectors.toList());
    }
}
