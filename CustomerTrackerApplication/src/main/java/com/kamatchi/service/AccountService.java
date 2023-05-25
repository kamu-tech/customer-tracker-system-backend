package com.kamatchi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kamatchi.dto.AccountRequest;
import com.kamatchi.dto.AccountResponse;
import com.kamatchi.dto.CustomerResponse;
import com.kamatchi.dto.TransferRequest;
import com.kamatchi.model.Account;
import com.kamatchi.repo.AccountRepository;

@Service
public class AccountService {
	RestTemplate restTemplate=new RestTemplate();
	@Autowired
	private AccountRepository repository;
	public String addAccount(AccountRequest acc) {
		Account account=new Account();
		int number=new Random().ints(10000, 99999).findFirst().getAsInt();
		account.setAccountNumber(number);
		account.setBalance(acc.getBalance());
		account.setAccountType(acc.getAccountType());
		account.setBankname(acc.getBankname());
		account.setBranch(acc.getBranch());
		CustomerResponse response=restTemplate.postForObject("http://localhost:8000/customers/create",acc, CustomerResponse.class);
		account.setCustomer_id(response.getId());
		repository.save(account);
		return "Account created successfully";
	}
	public String addNewAccount(AccountRequest acc,int id) {
		Account account=new Account();
		int number=new Random().ints(10000, 99999).findFirst().getAsInt();
		account.setAccountNumber(number);
		account.setBalance(acc.getBalance());
		account.setAccountType(acc.getAccountType());
		account.setBankname(acc.getBankname());
		account.setBranch(acc.getBranch());
		account.setCustomer_id(id);
		repository.save(account);
		return "Account created successfully";
	}
	public List<Account> displayAllAccount(){
		return repository.findAll();
	}
	public List<Account> getAccountByid(int id) {
		List<Account> account=repository.findAccountById(id);
		return account;
	}
	public List<AccountResponse> getAllAccount() {
		List<Account> account=repository.findAll();
		List<AccountResponse> accountResponse=new ArrayList<>();
		for(int i=0;i<account.size();i++) {
			AccountResponse response=new AccountResponse();
			response.setAccountNumber(account.get(i).getAccountNumber());
			response.setAccountType(account.get(i).getAccountType());
			response.setBalance(account.get(i).getBalance());
			response.setBankname(account.get(i).getBankname());
			response.setBranch(account.get(i).getBranch());
			CustomerResponse customerDetails=restTemplate.getForObject("http://localhost:8000/customers/display/{id}",CustomerResponse.class,account.get(i).getCustomer_id());
			response.setCustomer(customerDetails);
			accountResponse.add(response);
		}
		return accountResponse;
	}
	public String transfer(TransferRequest transfer) {
		Account fromId=repository.findById(transfer.getFromId()).get();
		Account toId=repository.findById(transfer.getToId()).get();
		double amount=transfer.getAmount();
		if(amount>0) {
		if(fromId.getBalance()>=amount) {
			fromId.setBalance(fromId.getBalance()-amount);
			repository.save(fromId);
			toId.setBalance(toId.getBalance()+amount);
			repository.save(toId);
			return "Success";
		}
		else {
			return "Insuffient funds";
		}
		}
		else {
			return "enter correct amount";
		}
	}
	public Account getBalance(int accountNumber) {
		Account account=repository.findById(accountNumber).get();
		return account;
		
	}
	public void deleteAccount(int id) {
		repository.deleteById(id);
	}
	

}
