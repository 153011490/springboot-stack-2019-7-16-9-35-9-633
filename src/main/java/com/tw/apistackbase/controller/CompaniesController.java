package com.tw.apistackbase.controller;

import com.tw.apistackbase.modle.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private List<Company> companies=Company.createComponiess();

    @GetMapping
    public List<Company> getAllCompany(){
        return companies;
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id") int id ){
        return Company.getComponyById(id);
    }
}
