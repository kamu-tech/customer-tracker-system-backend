package com.kamatchi.dto;

public class AccountResponse {
	
	private int accountNumber;
	
	private double balance;
	
	private String bankname;
	
	private String branch;
	
	private String accountType;
	public AccountResponse() {
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
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public AccountResponse(int accountNumber, double balance, String bankname, String branch,
			String accountType) {
		super();
		//this.customer = customer;
		
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.bankname = bankname;
		this.branch = branch;
		this.accountType = accountType;
	}
	

}
