package com.h2.hbr.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h2.hbr.demo.model.CustomerEntity;
 
@Repository
public interface CustomerRepository
        extends JpaRepository<CustomerEntity, Long> {
 
}
