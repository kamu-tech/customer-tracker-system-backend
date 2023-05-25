package com.kamatchi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kamatchi.dto.AccountRequest;
import com.kamatchi.dto.AccountResponse;
import com.kamatchi.dto.CustomerResponse;
import com.kamatchi.dto.TransferRequest;
import com.kamatchi.model.Account;
import com.kamatchi.service.AccountService;

@RestController
@CrossOrigin("*")
public class CustomerTrackerController {
	RestTemplate restTemplate=new RestTemplate();
	@Autowired
	private AccountService services;
	@PostMapping("accounts/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createAccount(@RequestBody AccountRequest acc) {
		return services.addAccount(acc);
	}
	@PostMapping("accounts/newcreate/{id}")
	public String createNewAccount(@RequestBody AccountRequest account,@PathVariable int id) {
		return services.addNewAccount(account,id);
	}
	@GetMapping("accounts/display/{id}")
	public List<Account> displayAccountById(@PathVariable int id) {
		return services.getAccountByid(id);
	}
	
	@GetMapping("accounts/display")
	public List<AccountResponse> displayAllAccounts(){
		return services.getAllAccount();
	}
	@PutMapping("accounts/transfer")
	public String transfer(@RequestBody TransferRequest transfer) {
		return services.transfer(transfer);
	}
	@GetMapping("accounts/displayAll")
	public List<Account> getAllAccounts(){
		return services.displayAllAccount();
	}
	@GetMapping("accounts/getBalance/{acc}")
	public Account getBalance(@PathVariable int acc){
		return services.getBalance(acc);
	}
	
	@GetMapping("customers/display")
	public String getAllCustomers() {
		String response=restTemplate.getForObject("http://localhost:8000/customers",String.class);
		return response;
	}
	@PutMapping("accounts/customers/edit/{id}")
	public String editCustomers(@RequestBody CustomerResponse customer,@PathVariable int id) {
		restTemplate.put("http://localhost:8000/customers/edit/"+id, customer);
		return "updated successfully";
	}
	@DeleteMapping("accounts/delete/{id}")
	public void deleteAccount(@PathVariable int id) {
	    services.deleteAccount(id);
	}
	@DeleteMapping("accounts/customers/delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		restTemplate.delete("http://localhost:8000/customers/delete/"+id);
	}
	
}
