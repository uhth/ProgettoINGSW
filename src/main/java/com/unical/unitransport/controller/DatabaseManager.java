package com.unical.unitransport.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	private static Connection connection;
	private static DatabaseManager instance;
	
	private DatabaseManager() {}
	
	public static Connection getConnection() {
		if( instance == null )
			instance = new DatabaseManager();
		try {
			if( connection == null || !connection.isValid( 5 ) )
			try {
				connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/dataUT", "postgres", "postgres" );
			} catch (SQLException e) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
