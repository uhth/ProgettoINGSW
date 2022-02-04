package com.unical.unitransport.controller.payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.unical.unitransport.controller.persistence.DatabaseManager;

public class PaymentDAO {
	
	
	private PaymentDAO() {}
	private static PaymentDAO instance;
	private static PaymentDAO initialize() {
		if( instance == null ) {
			instance = new PaymentDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.payment( "
					+ "payment_id serial PRIMARY KEY, "
					+ "sender_email VARCHAR(255) NOT NULL,"
					+ "reciver_email VARCHAR(255) NOT NULL,"
					+ "type INT NOT NULL, "
					+ "amount FLOAT NOT NULL, "
					+ "date_payment TIMESTAMP ); " ;
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert(Payment pay) {
		initialize();
		try {
			String sql = "insert into unitransport.payment( sender_email ,reciver_email, type, amount, date_payment) values( ?, ?, ?, ?, ?) ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString(1, pay.getEmail());
			statement.setString(2, pay.getEmail_rec());
			statement.setInt( 3, pay.getType() );
			statement.setFloat(4, pay.getAmount());
			statement.setTimestamp( 5, Timestamp.from( Instant.now() ) );
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
			String sql = "delete from unitransport.payment";
			Statement statement = DatabaseManager.getConnection().createStatement();
			statement.executeUpdate( sql );
			statement.close();
			return true;
		} catch ( SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Payment> getBySender( String sender ) {
		initialize();
		List<Payment> pagamenti = new ArrayList<Payment>();
		try {
			String sql = "select * from unitransport.payment where sender_email = ? ; ";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, sender );
			ResultSet rs = statement.executeQuery();
			while( rs.next() ) {
				Payment p = new Payment(rs.getInt(4) ,rs.getFloat(5), rs.getTimestamp(6), rs.getString(2), rs.getString(3));
				pagamenti.add(p);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagamenti;
	}
	
	//creare dao prendere per online
	//creare dao prendere per contrassegno
	
}
