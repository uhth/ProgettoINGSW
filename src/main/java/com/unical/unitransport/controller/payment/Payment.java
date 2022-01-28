package com.unical.unitransport.controller.payment;

import java.sql.Timestamp;

public class Payment {
	public static final int ONLINE = 0;
	public static final int CONTRASSEGNO = 1;
	
	private int payment_id;
	private int type;
	private float amount;
	private Timestamp date;
	private String email;
	
	public Payment(int type, float amount, Timestamp date, String email) {
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.email = email;
	}
	
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
