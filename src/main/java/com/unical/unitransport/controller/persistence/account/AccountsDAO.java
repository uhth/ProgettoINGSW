package com.unical.unitransport.controller.persistence.account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.unical.unitransport.controller.persistence.DatabaseManager;

public class AccountsDAO {

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
					+ "password VARCHAR ( 255 ) NOT NULL, "
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
			String sql = "insert into unitransport.accounts( email, password, created_on ) values( ?, ?, ? ); ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, account.getEmail() );
			statement.setString( 2, account.getPassword() );
			statement.setTimestamp( 3 , account.getCreatedOn() );
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateEmail( Account account, String newEmail ) {
		initialize();
		try {
			String sql = "update unitransport.accounts set email = ? where email = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, newEmail );
			statement.setString( 2, account.getEmail() );
			int rows_updated = statement.executeUpdate();
			statement.close();
			if( rows_updated == 0 ) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateLastLogin( Account account ) {
		initialize();
		try {
			String sql = "update unitransport.accounts set last_login = ? where email = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setTimestamp( 1, account.getLastLogin() );
			statement.setString( 2, account.getEmail() );
			int rows_updated = statement.executeUpdate();
			statement.close();
			if( rows_updated == 0 ) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updatePassword( Account account, String newPassword ) {
		initialize();
		try {
			String sql = "update unitransport.accounts set password = ? where email = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, newPassword );
			statement.setString( 2, account.getEmail() );
			int rows_updated = statement.executeUpdate();
			statement.close();
			if( rows_updated == 0 ) return false;
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
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, email );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				account = new Account( rs.getInt( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getTimestamp( 4 ), rs.getTimestamp( 5 ) );
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
				Account account = new Account( rs.getInt( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getTimestamp( 4 ), rs.getTimestamp( 5 ) );
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
			String sql = "delete from unitransport.accounts where email = ? ;";
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
	
	public static boolean removeAll() {
		initialize();
		try {
			String sql = "delete from unitransport.accounts ;"; 
			Statement statement = DatabaseManager.getConnection().createStatement();
			statement.executeUpdate( sql );				
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}