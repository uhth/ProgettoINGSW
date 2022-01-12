package com.unical.unitransport.controller.persistence.account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unical.unitransport.controller.persistence.DatabaseManager;

public class AccountRoleDAO {

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
	
	
	public static boolean insert( AccountRole accountRole ) {
		initialize();
		try {
			String sql = "insert into unitransport.account_roles ( user_id, role_id, grant_date ) "
					+ "values( ?, ?, ? ); ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , accountRole.getUserId() );
			statement.setInt( 2 , accountRole.getRoleId() );
			statement.setTimestamp( 3, accountRole.getGrantDate() );
			statement.executeUpdate( sql );				
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean removeAllFor( Account account ) {
		initialize();
		try {
			String sql = "remove from unitransport.account_roles where account_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , account.getUserId() );
			statement.executeUpdate( sql );			
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean removeAllFor( Role role ) {
		initialize();
		try {
			String sql = "remove from unitransport.account_roles where role_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , role.getRoleId() );
			statement.executeUpdate( sql );			
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean remove( AccountRole accountRole ) {
		initialize();
		try {
			String sql = "remove from unitransport.account_roles where account_id = ? and role_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , accountRole.getUserId() );
			statement.setInt( 2 , accountRole.getRoleId() );
			statement.executeUpdate( sql );			
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
		
	public static List<AccountRole> get( Account account ) {
		initialize();
		List<AccountRole> accountRoles = new ArrayList<AccountRole>();
		try {
			String sql = "select * from unitransport.account_roles";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				AccountRole accountRole = new AccountRole( rs.getInt( 0 ), rs.getInt( 1 ), rs.getTimestamp( 2 ) );
				accountRoles.add( accountRole );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountRoles;
	}
	
}