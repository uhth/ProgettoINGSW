package com.unical.unitransport.controller.persistence.shipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.unical.unitransport.controller.persistence.DatabaseManager;

public class ShipmentsSenderReceiverDAO {
	
	private ShipmentsSenderReceiverDAO() {}
	private static ShipmentsSenderReceiverDAO instance;
	private static ShipmentsSenderReceiverDAO initialize() {
		if( instance == null ) {
			instance = new ShipmentsSenderReceiverDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.shipments_sender_receiver( "
					+ "shipment_id serial UNIQUE NOT NULL, "
					+ "sender_email VARCHAR ( 255 ) NOT NULL, "
					+ "receiver_email VARCHAR ( 255 ) NOT NULL, "
					+ "PRIMARY KEY (shipment_id, sender_email, receiver_email), "
					+ "FOREIGN KEY (sender_email) "
					+ "		REFERENCES unitransport.accounts (email) ON DELETE CASCADE, "
					+ "FOREIGN KEY (shipment_id) "
					+ "		REFERENCES unitransport.shipments (shipment_id) ON DELETE CASCADE );";
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert( ShipmentSenderReceiver shipmentSenderReceiver ) {
		initialize();
		try {
			String sql = "insert into unitransport.shipments_sender_receiver( shipment_id, sender_email, receiver_email ) values( ?, ?, ? ) ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setInt( 1, shipmentSenderReceiver.getShipmentId() );
			statement.setString( 2, shipmentSenderReceiver.getSenderEmail() );
			statement.setString( 3, shipmentSenderReceiver.getReceiverEmail() );
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static ShipmentSenderReceiver getByShipmentId( String shipment_id ) {
		initialize();
		ShipmentSenderReceiver shipmentSenderReceiver = null;
		try {
			String sql = "select * from unitransport.shipments_sender_receiver where shipment_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, shipment_id );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				shipmentSenderReceiver = new ShipmentSenderReceiver( rs.getInt( 1 ), rs.getString( 2 ), rs.getString( 3 ) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shipmentSenderReceiver;
	}
	
	public static ShipmentSenderReceiver getBySenderEmail( String sender_email ) {
		initialize();
		ShipmentSenderReceiver shipmentSenderReceiver = null;
		try {
			String sql = "select * from unitransport.shipments_sender_receiver where sender_email = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, sender_email );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				shipmentSenderReceiver = new ShipmentSenderReceiver( rs.getInt( 1 ), rs.getString( 2 ), rs.getString( 3 ) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shipmentSenderReceiver;
	}
	
	public static List<ShipmentSenderReceiver> getAll() {
		initialize();
		List<ShipmentSenderReceiver> shipmentSenderReceivers = new ArrayList<ShipmentSenderReceiver>();
		try {
			String sql = "select * from unitransport.shipments_sender_receiver";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				ShipmentSenderReceiver shipmentSenderReceiver = new ShipmentSenderReceiver( rs.getInt( 1 ), rs.getString( 2 ), rs.getString( 3 ) );
				shipmentSenderReceivers.add( shipmentSenderReceiver );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shipmentSenderReceivers;
	}

	public static boolean remove( ShipmentSenderReceiver shipmentSenderReceiver ) {
		initialize();
		try {
			String sql = "remove from unitransport.shipments_sender_receiver where shipment_id = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setInt( 1, shipmentSenderReceiver.getShipmentId() );
			statement.executeUpdate();			
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
