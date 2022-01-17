package com.unical.unitransport.controller.persistence.spedizioniUtente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unical.unitransport.controller.persistence.DatabaseManager;

public class SpedizioneUtenteDAO {
	
	private SpedizioneUtenteDAO() {}
	private static SpedizioneUtenteDAO instance;
	private static SpedizioneUtenteDAO initialize() {
		if (instance==null) {
			instance = new SpedizioneUtenteDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.spedizioni_utenti( "
					+ "tracking_number VARCHAR ( 255 ) PRIMARY KEY, "
					+ "email VARCHAR ( 255 ) NOT NULL,"
					+ "luogo_ritiro VARCHAR ( 255 ) NOT NULL); ";
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert(SpedizioneUtente spedizione) {
		initialize();
		try {
			String sql = "insert into unitransport.spedizioni_utenti( tracking_number, email, luogo_ritiro) values( ?, ?, ? ) ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, spedizione.getTracking_code() );
			statement.setString( 2, spedizione.getEmail());
			statement.setString( 3, spedizione.getLuogo_ritiro());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
		public static boolean update( SpedizioneUtente spedizione, String luogo_ritiro ) {
		initialize();
		try {
			String sql = "update unitransport.spedizioni_utenti set luogo_ritiro = ? where tracking_number = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, luogo_ritiro );
			statement.setString( 2, spedizione.getTracking_code() );
			int rows_updated = statement.executeUpdate();
			statement.close();
			if( rows_updated == 0 ) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static boolean remove( SpedizioneUtente spedizione ) {
		initialize();
		try {
			String sql = "delete from unitransport.shipments where tracking_number = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, spedizione.getTracking_code());
			statement.executeUpdate();				
			statement.close();
 			String sql2 = "delete from unitransport.spedizioni_utenti where tracking_number = ? ;";
			PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement(sql2);
			statement2.setString( 1, spedizione.getTracking_code());
			statement2.executeUpdate();				
			statement2.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<SpedizioneUtente> getAll(String utente) {
		initialize();
		List<SpedizioneUtente> spedizioni = new ArrayList<SpedizioneUtente>();
		try {
			String sql = "select * from unitransport.spedizioni_utenti where email = ?";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString(1, utente);
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				SpedizioneUtente spedizione = new SpedizioneUtente(rs.getString(2), rs.getString(1), rs.getString(3));
				spedizioni.add( spedizione );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spedizioni;
	}
	

}
