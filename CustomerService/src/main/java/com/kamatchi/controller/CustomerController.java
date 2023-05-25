
package com.kamatchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamatchi.dto.CustomerResponse;
import com.kamatchi.model.Customer;
import com.kamatchi.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	private CustomerService service;
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerResponse>> getCustomerDetails(){
		List<CustomerResponse> customerResponse=service.getAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
	}
	@PutMapping("/customers/edit/{id}")
	public Customer editCustomerDetails(@RequestBody Customer customer,@PathVariable int id) {
		return service.editCustomer(customer,id);
	}
	@PostMapping("/customers/create")
	public Customer createCustomerDetails(@RequestBody Customer customer) {
		return service.display(customer);
	}
	@GetMapping("/customers/displayemail/{email}")
	public int findId(@PathVariable String email) {
		return service.findId(email);
	}
	@GetMapping("/customers/display")
	public List<Customer> displayAllcustomer(){
		return service.displayAllCustomer();
	}
	@GetMapping("customers/display/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return service.displayById(id);
	}
	@DeleteMapping("customers/delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		service.delete(id);
	}
}
