package com.example.h2REST.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.example.h2REST.model.Customer;
import com.example.h2REST.repository.CustomerRepository;

@EnableAsync
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
	
    public Customer createCustomer(Customer Customer){
    	return customerRepository.save(Customer);
    }
    
    @Async
    public Customer createDelayCustomer(Customer Customer){
    	
    	LOG.info("Delay Add:: Start");
    	
    	try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	LOG.info("Delay Add:: End");
    	
    	
    	return customerRepository.save(Customer);
    }

    
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    
    public Customer editCustomer(Customer Customer) {
        return customerRepository.save(Customer);
    }

    
    public void deleteCustomer(Customer Customer) {
        customerRepository.delete(Customer);
    }

    
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    
    public List<Customer> getAllCustomers(int pageNumber, int pageSize) {
        return customerRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
    }

    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    
    public long countCustomers() {
        return customerRepository.count();
    }
}
