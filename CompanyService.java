package com.example.demo;

import java.util.Comparator;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRespository;
	

	public String updateCompany(Company company) {
		companyRespository.save(company);
		return "phoneNum is update:"+company.getPhoneNum();
	}

	
	public List<Company> getsortingcompanies() {
        List<Company> companies = companyRespository.findAll();
        companies.sort(Comparator.comparingInt(Company::getRent).reversed());
        return companies.subList(0, 2);
    }
}
	
	
