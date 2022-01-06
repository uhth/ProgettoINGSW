package com.unical.unitransport.controller.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO {

	
	//AdminDAO creation methods
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insert( Role role ) {
		initialize();
		try {
			String sql = "insert or replace into unitransport.roles( role_name ) values( ? ); ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, role.getRoleName() );
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Role> getAll() {
		initialize();
		List<Role> roles = new ArrayList<Role>();
		try {
			String sql = "select * from unitransport.roles";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				Role role = new Role( rs.getInt( 0 ), rs.getString( 1 ) );
				roles.add( role );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
}