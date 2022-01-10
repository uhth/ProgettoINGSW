package com.unical.unitransport.controller.persistence.shipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.unical.unitransport.controller.persistence.DatabaseManager;

public class ShipmentsDAO {

	private ShipmentsDAO() {}
	private static ShipmentsDAO instance;
	private static ShipmentsDAO initialize() {
		if( instance == null ) {
			instance = new ShipmentsDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.shipments( "
					+ "shipment_id serial PRIMARY KEY, "
					+ "tracking_number VARCHAR ( 255 ) UNIQUE NOT NULL, "
					+ "status INT NOT NULL, "
					+ "created_on TIMESTAMP NOT NULL, "
				    + "last_update TIMESTAMP );";
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert( Shipment shipment ) {
		initialize();
		try {
			String sql = "insert or replace into unitransport.shipments( tracking_number, status, created_on ) values( ?, ?, ? ); ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, shipment.getTrackingNumber() );
			statement.setInt( 2, shipment.getStatus() );
			statement.setTimestamp( 3, Timestamp.from( Instant.now() ) );
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static Shipment getByTrackingNumber( String tacking_number ) {
		initialize();
		Shipment shipment = null;
		try {
			String sql = "select * from unitransport.shipments where tracking_number = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, tacking_number );
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				shipment = new Shipment( rs.getInt( 0 ), rs.getString( 1 ), rs.getInt( 2 ), rs.getTimestamp( 3 ), rs.getTimestamp( 4 ) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shipment;
	}
	
	public static List<Shipment> getAll() {
		initialize();
		List<Shipment> shipments = new ArrayList<Shipment>();
		try {
			String sql = "select * from unitransport.accounts";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				Shipment shipment = new Shipment( rs.getInt( 0 ), rs.getString( 1 ), rs.getInt( 2 ), rs.getTimestamp( 3 ), rs.getTimestamp( 4 ) );
				shipments.add( shipment );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shipments;
	}

	public static boolean remove( Shipment shipment ) {
		initialize();
		try {
			String sql = "remove from unitransport.accounts where tracking_number = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, shipment.getTrackingNumber() );
			statement.executeUpdate();			
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
