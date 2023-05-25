package com.kamatchi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="account")
public class Account {
    @Id
	@Column(name="account_number")
	private int accountNumber;
	@Column(name="balance")
	private double balance;
	@Column(name="bankname")
	private String bankname;
	@Column(name="branch")
	private String branch;
	@Column(name="account_type")
	private String account_type;
    private int customer_id;
    
	
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Account() {
		super();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber ) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccountType() {
		return account_type;
	}
	public void setAccountType(String account_type) {
		this.account_type = account_type;
	}
	public Account(int accountNumber, double balance, String bankname, String branch,
			String accountType) {
		super();
		//this.customer = customer;
		
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.bankname = bankname;
		this.branch = branch;
		this.account_type = accountType;
	}
	

}
