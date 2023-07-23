package com.example.demo.rest;

import java.util.ArrayList;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Company;
import com.example.demo.CompanyRepository;
import com.example.demo.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	CompanyRepository companyRespository;
	@Autowired
    CompanyService companyservice;
	
	
	
	@PostMapping("/addcompany")
	public Company saveCompany(@RequestBody Company company) {
		return companyRespository.save(company);
	}
		
	@GetMapping("/Companies")
	public List<Company> getAllCompany(){
		return companyRespository.findAll();
	}
	@GetMapping("/companies/sortedcompanies")
	public List<Company> getsortingcompanies() {
		List<Company> Company = companyservice.getsortingcompanies();
	    return Company;
	}
	@PutMapping("/add")
	public String UpdateCompany(@RequestBody Company company) {
		return companyservice.updateCompany(company);
	}
	@PutMapping( "/Companies/{id}")
	 public String updateCompany(@RequestBody Company company ,@PathVariable Integer id ) {
		Company updateCompany = companyRespository.findById(id).get();
		updateCompany.setCompanyName(company.getCompanyName());
		updateCompany.setRent(company.getRent());
		updateCompany.setPhoneNum(company.getPhoneNum());
		companyRespository.save(updateCompany);
		return "updated.....";
	 }
	@DeleteMapping("/Companies/{id}")
	public String deleteCompany(@PathVariable Integer id) {
		companyRespository.deleteById(id);
		return "deleted";		
	}



}
