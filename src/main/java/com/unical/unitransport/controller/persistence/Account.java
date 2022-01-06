package com.unical.unitransport.controller.persistence;

import java.sql.Timestamp;

public class Account {
	
	private int user_id;
	private String email;
	private String password;
	private Timestamp created_on;
	private Timestamp last_login;

	public Account( int user_id, String email, String password, Timestamp created_on, Timestamp last_login ) {

	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int used_id) {
		this.user_id = used_id;
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

	public Timestamp getCreatedOn() {
		return created_on;
	}

	public void setCreatedOn(Timestamp created_on) {
		this.created_on = created_on;
	}

	public Timestamp getLastLogin() {
		return last_login;
	}

	public void setLastLogin(Timestamp last_login) {
		this.last_login = last_login;
	}
	
	
	
}
