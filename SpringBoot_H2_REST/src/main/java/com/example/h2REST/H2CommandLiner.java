package com.example.h2REST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.h2REST.model.Customer;
import com.example.h2REST.service.CustomerService;

@SpringBootApplication
public class H2CommandLiner implements CommandLineRunner{


	private static final Logger LOG = LoggerFactory.getLogger(H2CommandLiner.class);
	
	@Autowired
	private CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(H2CommandLiner.class, args);
	}

	@Override
	public void run(String... strings) {

		LOG.info("Number of Customers: {}", service.countCustomers());

		Customer Customer = service.createCustomer(new Customer("Brijesz", 12));
		LOG.info("Create Customer : {}", Customer);

		LOG.info("Number of Customers: {}", service.countCustomers());

		Customer.setName("Brijesh");
		service.editCustomer(Customer);
		LOG.info("Modify typo in name  : {}", Customer);

		service.deleteCustomer(Customer);
		LOG.info("Count on Delete Customer, count: {}", service.countCustomers());
	}

}
