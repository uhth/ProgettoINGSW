package com.unical.unitransport.controller.persistence;

import java.sql.Timestamp;
import java.time.Instant;

public class AccountRole {
	
	private int user_id;
	private int role_id;
	private Timestamp grant_date;
	
	
	public AccountRole(int user_id, int role_id, Timestamp grant_date) {
		this.user_id = user_id;
		this.role_id = role_id;
		this.grant_date = grant_date;
	}
	
	public AccountRole(int user_id, int role_id ) {
		this.user_id = user_id;
		this.role_id = role_id;
		this.grant_date = Timestamp.from( Instant.now() );
	}


	public int getUserId() {
		return user_id;
	}


	public int getRoleId() {
		return role_id;
	}


	public Timestamp getGrantDate() {
		return grant_date;
	}


	public void setUserId(int user_id) {
		this.user_id = user_id;
	}


	public void setRoleId(int role_id) {
		this.role_id = role_id;
	}


	public void setGrantDate(Timestamp grant_date) {
		this.grant_date = grant_date;
	}
	
	
	
}
