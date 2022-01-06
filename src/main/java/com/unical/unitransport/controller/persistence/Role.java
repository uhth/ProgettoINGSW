package com.unical.unitransport.controller.persistence;

public class Role {
	
	private int role_id;
	private String role_name;
	
	public Role( int role_id, String role_name ) {
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public int getRoleId() {
		return role_id;
	}

	public void setRoleId( int role_id ) {
		this.role_id = role_id;
	}

	public String getRoleName() {
		return role_name;
	}

	public void setRoleName( String role_name ) {
		this.role_name = role_name;
	}
	
	
}
