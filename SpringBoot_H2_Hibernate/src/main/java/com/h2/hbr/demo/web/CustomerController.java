package com.h2.hbr.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.hbr.demo.exception.RecordNotFoundException;
import com.h2.hbr.demo.model.CustomerEntity;
import com.h2.hbr.demo.service.CustomerService;
 
@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    CustomerService service;
 
    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> list = service.getAllCustomers();
 
        return new ResponseEntity<List<CustomerEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        CustomerEntity entity = service.getCustomerById(id);
 
        return new ResponseEntity<CustomerEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerEntity> createOrUpdateCustomer(@RequestBody CustomerEntity employee)
                                                    throws RecordNotFoundException {
        CustomerEntity updated = service.createOrUpdateCustomer(employee);
        return new ResponseEntity<CustomerEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteCustomerById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteCustomerById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}