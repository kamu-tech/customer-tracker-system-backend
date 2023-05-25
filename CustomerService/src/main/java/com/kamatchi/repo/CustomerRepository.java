package com.kamatchi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamatchi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	

}
