package com.kamatchi.dto;

public class TransferRequest {
	private int fromId;
	private int toId;
	private double amount;
	
	public TransferRequest() {
		super();
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransferRequest(int fromId, int toId, double amount) {
		super();
		this.fromId = fromId;
		this.toId = toId;
		this.amount = amount;
	}
	
}
