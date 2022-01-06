package com.unical.unitransport.controller.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;

public class AccountRoleDAO {

	
	//AdminDAO creation methods
	private AccountRoleDAO() {}
	private static AccountRoleDAO instance;
	private static AccountRoleDAO initialize() {
		if( instance == null ) {
			instance = new AccountRoleDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.account_roles ( "
					+ "user_id INT NOT NULL, "
					+  "role_id INT NOT NULL, "
					+ "grant_date TIMESTAMP, "
					+ "PRIMARY KEY (user_id, role_id), "
					+ "FOREIGN KEY (role_id) "
					+ "    REFERENCES roles (role_id), "
					+ "FOREIGN KEY (user_id) "
					+ "    REFERENCES accounts (user_id) );" ;
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public static void insertAccountRole( Account account, Role role ) {
		insertAccountRole( account, role, Timestamp.from( Instant.now() ) );
	}
	
	
	public static void insertAccountRole( Account account, Role role, Timestamp grant_date ) {
		initialize();
		try {
			String sql = "insert or replace into unitransport.account_roles ( user_id, role_id, grant_date ) "
					+ "values( ?, ?, ? ); ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , account.getUserId() );
			statement.setInt( 2 , role.getRoleId() );
			statement.setTimestamp( 3, grant_date );
			statement.executeUpdate( sql );				
			statement.close();
		} catch (SQLException e) {
		
		}
	}
	
	public static int getRoleId( Account account ) {
		initialize();
		int role_id = -1;
		try {
			String sql = "select role_id from unitransport.account_roles where user_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , account.getUserId() );
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				role_id = rs.getInt( 0 );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role_id;
	}
	
}