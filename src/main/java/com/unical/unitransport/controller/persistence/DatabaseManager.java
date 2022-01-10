package com.unical.unitransport.controller.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	
	private static DatabaseManager instance;
	private static Connection connection;
	private static String address[] = { "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres" };
	
	//DatabaseManager creation methods
	private DatabaseManager() {}
	private static DatabaseManager initialize() {
		if( instance == null ) {
			instance = new DatabaseManager();
			createSchema();
		}
		return instance;
	}
	
	//gets connection to db ( initializes DatabaseManager if it hasn't already been done )
	public static Connection getConnection() {
		initialize();
		try {
			 if( connection == null || connection.isClosed() )
				 connection = DriverManager.getConnection( address[ 0 ], address[ 1 ], address[ 2 ] );
		} catch (SQLException e) {
			System.err.println("Unable to connect to db");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void createSchema() {
		try {
			String sql = "CREATE SCHEMA IF NOT EXISTS unitransport ;";
			Statement statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
					
}
