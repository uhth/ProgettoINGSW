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
					+ "user_id INT, "
					+  "role_id INT NOT NULL, "
					+ "grant_date TIMESTAMP, "
					+ "PRIMARY KEY (user_id), "
					+ "FOREIGN KEY (role_id) "
					+ "    REFERENCES unitransport.roles (role_id) ON DELETE CASCADE, "
					+ "FOREIGN KEY (user_id) "
					+ "    REFERENCES unitransport.accounts (user_id) ON DELETE CASCADE ) ; " ;
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
					+ "values( ?, ?, ? ) on conflict( user_id ) do update set role_id = ?, grant_date = ? ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , accountRole.getUserId() );
			statement.setInt( 2 , accountRole.getRoleId() );
			statement.setTimestamp( 3, accountRole.getGrantDate() );
			statement.setInt( 4 , accountRole.getRoleId() );
			statement.setTimestamp( 5, accountRole.getGrantDate() );
			statement.executeUpdate();				
			statement.close();
			return true;
		} catch (SQLException e) {
			System.out.println("insert bad");
			return false;
		}
	}
		
	public static boolean remove( Account account ) {
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
	
	public static boolean remove( Role role ) {
		initialize();
		try {
			String sql = "delete from unitransport.account_roles where role_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1 , role.getRoleId() );
			statement.executeUpdate( sql );			
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

		
	public static AccountRole getFor( Account account ) {
		initialize();
		AccountRole accountRole = null;
		try {
			String sql = "select * from unitransport.account_roles ;";
			Statement statement = DatabaseManager.getConnection().createStatement();		
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				if(account.getUserId()==rs.getInt(1))
				accountRole = new AccountRole( rs.getInt( 1 ), rs.getInt( 2 ), rs.getTimestamp( 3 ) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountRole;
	}
	
	public static boolean removeAll() {
		initialize();
		try {
			String sql = "delete from unitransport.account_roles ;";
			Statement statement = DatabaseManager.getConnection().createStatement();
			statement.executeUpdate( sql );
			statement.close();
			return true;
		} catch ( SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<AccountRole> getAll() {
		initialize();
		List<AccountRole> accountRoles = new ArrayList<AccountRole>();
		try {
			String sql = "select * from unitransport.account_roles";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				AccountRole accountRole = new AccountRole( rs.getInt( 1 ), rs.getInt( 2 ), rs.getTimestamp( 3 ) );
				accountRoles.add( accountRole );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountRoles;
	}
	
}