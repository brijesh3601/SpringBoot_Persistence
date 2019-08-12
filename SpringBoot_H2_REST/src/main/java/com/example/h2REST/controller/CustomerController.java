package com.example.h2REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2REST.model.Customer;
import com.example.h2REST.service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService contactService;
	
	@RequestMapping(value ="list")
	private String method() {
		return  "all customers";

	}
	
	@RequestMapping(value ="add")
	private void addContact(){
		contactService.createCustomer(new Customer("Brijesh", 12));

	}
	


	@RequestMapping(value ="dyladd")
	private void delayAddContact(){
		
		contactService.createDelayCustomer(new Customer("Brijesh", 12));

	}
	
	
	@RequestMapping(value ="count")
	private long countContact() {
		return contactService.countCustomers();
	}

}
