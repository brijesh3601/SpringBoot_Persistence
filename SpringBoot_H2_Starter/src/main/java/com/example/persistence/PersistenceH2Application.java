package com.example.persistence;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PersistenceH2Application {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PersistenceH2Application.class, args);
	}
	
	@PostConstruct
	private void initDb() {
	    String sqlStatements[] = {
	      "drop table customers if exists",
	      "create table customers(id serial,first_name varchar(255),last_name varchar(255))",
	      "insert into customers(first_name, last_name) values('Eugen','Paraschiv')",
	      "insert into customers(first_name, last_name) values('Scott','Tiger')"
	    };
	 
	    Arrays.asList(sqlStatements).forEach(sql -> {
	        jdbcTemplate.execute(sql);
	    });
	 
	    
	}

}
