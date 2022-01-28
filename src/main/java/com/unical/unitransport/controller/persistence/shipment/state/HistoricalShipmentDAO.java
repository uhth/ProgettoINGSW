package com.unical.unitransport.controller.persistence.shipment.state;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.unical.unitransport.controller.persistence.DatabaseManager;
import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;

public class HistoricalShipmentDAO {
	
	private HistoricalShipmentDAO() {}
	private static HistoricalShipmentDAO instance;
	private static HistoricalShipmentDAO initialize() {
		if( instance == null ) {
			instance = new HistoricalShipmentDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.historical_shipment( "
					+ "id serial PRIMARY KEY, "
					+ "tracking_number VARCHAR ( 255 ) NOT NULL, "
					+ "date TIMESTAMP NOT NULL, "
					+ "status INT NOT NULL, "
				    + "last_location VARCHAR ( 255 ) DEFAULT 'UNKNOWN'"
				    + ") ; ";
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert( HistoricalShipment shipment ) {
		initialize();
		try {
			String sql = "insert into unitransport.historical_shipment( tracking_number, date, status, last_location ) values( ?, ?, ?, ? ) ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, shipment.getTracking_number() );
			statement.setTimestamp( 2, shipment.getDate() );
			statement.setInt( 3, shipment.getStatus() );
			statement.setString( 4, shipment.getLast_location() );

			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<HistoricalShipment> getByTrackingNumber( String tacking_number ) {
		initialize();
		HistoricalShipment shipment = null;
		ArrayList<HistoricalShipment> array = new ArrayList<HistoricalShipment>();
		
		try {
			String sql = "select * from unitransport.historical_shipment where tracking_number = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, tacking_number );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				shipment = new HistoricalShipment( rs.getString( 2 ), rs.getTimestamp( 3 ), rs.getInt( 4 ), rs.getString( 5 ));
				array.add(shipment);
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}
	
}

