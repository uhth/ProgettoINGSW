package com.unical.unitransport.controller.persistence.account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unical.unitransport.controller.persistence.DatabaseManager;

public class RolesDAO {

	private RolesDAO() {}
	private static RolesDAO instance;
	private static RolesDAO initialize() {
		if( instance == null ) {
			instance = new RolesDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.roles( "
					+ "role_id serial PRIMARY KEY, "
					+ "role_name VARCHAR ( 255 ) UNIQUE NOT NULL );";
			statement.executeUpdate( sql );	
			statement.close();
			if( getByName( "admin" ) != null ) {
				RolesDAO.insert( new Role( "admin" ) );
				RolesDAO.insert( new Role( "corriere" ) );
				RolesDAO.insert( new Role( "user" ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert( Role role ) {
		initialize();
		try {
			String sql = "insert into unitransport.roles( role_name ) values( ? ) ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, role.getRoleName() );
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
			String sql = "delete from unitransport.roles";
			Statement statement = DatabaseManager.getConnection().createStatement();
			statement.executeUpdate( sql );
			statement.close();
			return true;
		} catch ( SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean remove( Role role ) {
		initialize();
		try {
			String sql = "delete from unitransport.roles where role_name = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1 , role.getRoleName() );
			statement.executeUpdate();
			statement.close();
			return true;
		} catch ( SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static Role getById( int id ) {
		initialize();
		Role role = null;
		try {
			String sql = "select * from unitransport.roles where role_id = ? ; ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1, id );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				role = new Role( rs.getInt( 1 ), rs.getString( 2 ) );
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public static Role getByName( String name ) {
		initialize();
		Role role = null;
		try {
			String sql = "select * from unitransport.roles where role_name = ? ; ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, name );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				role = new Role( rs.getInt( 1 ), rs.getString( 2 ) );
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public static List<Role> getAll() {
		initialize();
		List<Role> roles = new ArrayList<Role>();
		try {
			String sql = "select * from unitransport.roles";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				Role role = new Role( rs.getInt( 1 ), rs.getString( 2 ) );
				roles.add( role );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
}