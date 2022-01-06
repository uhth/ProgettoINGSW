package com.unical.unitransport.controller.persistence;

import java.sql.Timestamp;

public class Account {
	
	private int used_id;
	private String email;
	private String password;
	private Timestamp created_on;
	private Timestamp last_login;

	public Account( int user_id, String email, String password, Timestamp created_on, Timestamp last_login ) {

	}

	public int getUsed_id() {
		return used_id;
	}

	public void setUsed_id(int used_id) {
		this.used_id = used_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}
	
	
	
}
