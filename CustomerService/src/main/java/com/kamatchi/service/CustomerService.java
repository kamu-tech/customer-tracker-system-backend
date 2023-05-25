package com.kamatchi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kamatchi.dto.AccountResponse;
import com.kamatchi.dto.CustomerResponse;
import com.kamatchi.model.Customer;
import com.kamatchi.repo.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	public List<CustomerResponse> getAllCustomer() {
		List<Customer> customer=repository.findAll();
		List<CustomerResponse> customerResponse=new ArrayList<>();
		for(int i=0;i<customer.size();i++) {
			CustomerResponse response=new CustomerResponse();
			response.setId(customer.get(i).getId());
			response.setName(customer.get(i).getName());
			response.setAge(customer.get(i).getAge());
			response.setGender(customer.get(i).getGender());
			response.setPhone(customer.get(i).getPhone());
			response.setEmail(customer.get(i).getEmail());
			List<AccountResponse> account=(List<AccountResponse>) restTemplate.getForObject("http://localhost:8001/accounts/display/{id}",AccountResponse.class,response.getId());
			response.setAccountDetails(account);
			customerResponse.add(response);
		}
		return customerResponse;
	}
	public List<Customer> displayAllCustomer(){
		return repository.findAll();
	}
	public int findId(String email) {
		List<Customer> c=repository.findAll();
		for(int i=0;i<c.size();i++) {
			if(c.get(i).getEmail().equals(email)) {
				return c.get(i).getId();
			}
		}
		return 0;
	}
	public Customer editCustomer(Customer customer,int id) {
		Customer updateCustomer=displayById(id);
		updateCustomer.setName(customer.getName());
		updateCustomer.setAge(customer.getAge());
		updateCustomer.setGender(customer.getGender());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setPhone(customer.getPhone());
		return repository.save(updateCustomer);
	}
	public Customer display(Customer customer) {
		return repository.save(customer);
	}
	public Customer displayById(int id) {
		return repository.findById(id).get();
	}
	public void delete(int id) {
		repository.deleteById(id);
	}

}
