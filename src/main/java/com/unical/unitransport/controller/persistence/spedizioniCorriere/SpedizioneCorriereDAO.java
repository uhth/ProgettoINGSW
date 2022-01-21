package com.unical.unitransport.controller.persistence.spedizioniCorriere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.unical.unitransport.controller.persistence.DatabaseManager;
import com.unical.unitransport.controller.persistence.shipment.Shipment;

public class SpedizioneCorriereDAO {
	
	private SpedizioneCorriereDAO() {}
	private static SpedizioneCorriereDAO instance;
	private static SpedizioneCorriereDAO initialize() {
		if (instance==null) {
			instance = new SpedizioneCorriereDAO();
			createTable();
		}
		return instance;
	}
	
	private static void createTable() {
		try {
			Statement statement = DatabaseManager.getConnection().createStatement();
			String sql = "create table if not exists "
					+ "unitransport.spedizioni_corrieri( "
					+ "tracking_number VARCHAR ( 255 ) PRIMARY KEY, "
					+ "email VARCHAR ( 255 ) NOT NULL"
					+ "); ";
			statement.executeUpdate( sql );	
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insert(SpedizioneCorriere spedizione) {
		initialize();
		try {
			String sql = "insert into unitransport.spedizioni_corrieri( tracking_number, email) values( ?, ?) ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement( sql );
			statement.setString( 1, spedizione.getTracking_code() );
			statement.setString( 2, spedizione.getEmail());
			statement.executeUpdate();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public static boolean remove( SpedizioneCorriere spedizione ) {
		initialize();
		try {
			String sql = "delete from unitransport.shipments where tracking_number = ? ;";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString( 1, spedizione.getTracking_code());
			statement.executeUpdate();				
			statement.close();
 			String sql2 = "delete from unitransport.spedizioni_corrieri where tracking_number = ? ;";
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
	
	public static List<SpedizioneCorriere> getAll(String corriere) {
		initialize();
		List<SpedizioneCorriere> spedizioni = new ArrayList<SpedizioneCorriere>();
		try {
			String sql = "select * from unitransport.spedizioni_corrieri where email = ?";
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
			statement.setString(1, corriere);
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				SpedizioneCorriere spedizione = new SpedizioneCorriere(rs.getString(2), rs.getString(1));
				spedizioni.add( spedizione );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spedizioni;
	}
	
	public static List<String> getAllSpedizioniCorriere(String corriere) {
		initialize();
		List<String> spedizioni = new ArrayList<String>();
		try {
			String sql = "select * from unitransport.spedizioni_corrieri;";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			
			while( rs.next() ) {
				if (rs.getString(2).equals(corriere))
					spedizioni.add( rs.getString(1) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spedizioni;
	}
	
	
	public static List<String> getAllSpedizioniString() {
		initialize();
		List<String> spedizioni = new ArrayList<String>();
		try {
			String sql = "select * from unitransport.shipments ;";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				spedizioni.add( rs.getString(2) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spedizioni;
	}
	
	public static List<String> getAllDisponibiliString() {
		initialize();
		List<String> spedizioniConCorriere = new ArrayList<String>();
		try {
			String sql = "select * from unitransport.spedizioni_corrieri ;";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			while( rs.next() ) {
				spedizioniConCorriere.add( rs.getString(1) );
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<String> spedizioniDisponibili = SpedizioneCorriereDAO.getAllSpedizioniString();

		for (String spedizioneDaEliminare: spedizioniConCorriere) {
			if (spedizioniDisponibili.contains(spedizioneDaEliminare))
				spedizioniDisponibili.remove(spedizioneDaEliminare);
		}
		
		
		return spedizioniDisponibili;
	}

	public static boolean spedizioneGiaAssegnata(String tracking) {
		initialize();
		try {
			String sql = "select * from unitransport.spedizioni_corrieri;";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			
			while( rs.next() ) {
				if (rs.getString(1).equals(tracking))
					return true;
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean spedizioneAppartenenteCorriere(String tracking, String corriere) {
		initialize();
		try {
			String sql = "select * from unitransport.spedizioni_corrieri;";
			Statement statement = DatabaseManager.getConnection().createStatement();
			ResultSet rs = statement.executeQuery( sql );
			
			while( rs.next() ) {
				if (rs.getString(1).equals(tracking) && rs.getString(2).equals(corriere))
					return true;
			}					
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
