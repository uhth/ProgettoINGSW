package com.unical.unitransport.controller.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAO {

	//
	
	//AdminDAO creation methods
	private AccountsDAO() {}
	private static AccountsDAO instance;
	private static AccountsDAO initialize() {
		if( instance == null ) {
			instance = new AccountsDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.accounts( "
					+ "user_id serial PRIMARY KEY, "
					+ "email VARCHAR ( 255 ) UNIQUE NOT NULL, "
					+ "password VARCHAR ( 50 ) NOT NULL, "
					+ "created_on TIMESTAMP NOT NULL, "
				    + "last_login TIMESTAMP );";
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert( Account account ) {
		initialize();
		try {
			String sql = "insert or replace into unitransport.accounts( email, password, created_on ) values( ?, ?, ? ); ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, account.getEmail() );
			statement.setString( 2, account.getPassword() );
			statement.setTimestamp( 3 , Timestamp.from( Instant.now() ));
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Account getByEmail( String email ) {
		initialize();
		Account account = null;
		try {
			String sql = "select * from unitransport.accounts where email = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, email );
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				account = new Account( rs.getInt( 0 ), rs.getString( 1 ), rs.getString( 2 ), rs.getTimestamp( 3 ), rs.getTimestamp( 4 ) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public static List<Account> getAll() {
		initialize();
		List<Account> accounts = new ArrayList<Account>();
		try {
			String sql = "select * from unitransport.accounts";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				Account account = new Account( rs.getInt( 0 ), rs.getString( 1 ), rs.getString( 2 ), rs.getTimestamp( 3 ), rs.getTimestamp( 4 ) );
				accounts.add( account );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static boolean remove( Account account ) {
		initialize();
		try {
			String sql = "remove from unitransport.accounts where email = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, account.getEmail() );
			statement.executeUpdate();				
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}