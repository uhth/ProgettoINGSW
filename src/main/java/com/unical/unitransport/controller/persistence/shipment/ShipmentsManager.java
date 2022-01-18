package com.unical.unitransport.controller.persistence.shipment;

import java.security.SecureRandom;

public interface ShipmentsManager {
	
	public static Shipment registerShipment( String sender_email, String receiver_email ) {
		String tracking_number = trackingCasuale();
		while( ShipmentsDAO.getByTrackingNumber( tracking_number ) != null )
			tracking_number = trackingCasuale();
		
		Shipment shipment = new Shipment( tracking_number );
		if( !ShipmentsDAO.insert( shipment ) ) return null;
		shipment = ShipmentsDAO.getByTrackingNumber( tracking_number );
		ShipmentSenderReceiver shipmentSenderReceiver = new ShipmentSenderReceiver( shipment.getShipmentId(), sender_email, receiver_email );
		if( !ShipmentsSenderReceiverDAO.insert( shipmentSenderReceiver ) ) {
			ShipmentsDAO.remove( shipment );
			return null;
		}
		return shipment;
	}
	
	public static Shipment registerShipment( String tracking,  String sender_email, String receiver_email ) {


		if( ShipmentsDAO.getByTrackingNumber(tracking)==null ) return null;
		Shipment shipment = ShipmentsDAO.getByTrackingNumber( tracking );
		ShipmentSenderReceiver shipmentSenderReceiver = new ShipmentSenderReceiver( shipment.getShipmentId(), sender_email, receiver_email );
		if( !ShipmentsSenderReceiverDAO.insert( shipmentSenderReceiver ) ) {
			ShipmentsDAO.remove( shipment );
			return null;
		}
		return shipment;
	}
	
	
	public static boolean unregisterShipment( String trackingNumber ) {
		Shipment shipment = ShipmentsDAO.getByTrackingNumber( trackingNumber );
		return ShipmentsDAO.remove( shipment );
	}
	
	public static boolean updateShipment( String trackingNumber, int status, String last_location ) {
		Shipment shipment = ShipmentsDAO.getByTrackingNumber( trackingNumber );
		if( shipment == null ) return false;
		return ShipmentsDAO.update( shipment, status, last_location );
	}
	
	public static boolean updateShipment( String trackingNumber, int status ) {
		Shipment shipment = ShipmentsDAO.getByTrackingNumber( trackingNumber );
		if( shipment == null ) return false;
		return ShipmentsDAO.update( shipment, status, shipment.getLastLocation() );
	}
	
	public static boolean updateShipment( String trackingNumber, String last_location ) {
		Shipment shipment = ShipmentsDAO.getByTrackingNumber( trackingNumber );
		if( shipment == null ) return false;
		return ShipmentsDAO.update( shipment, shipment.getStatus(), last_location );
	}
	
	public static String trackingCasuale() {
		String tracking;
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = lower.toUpperCase();
        String numeri = "0123456789";
        String perRandom = upper + lower + numeri;
        int lunghezzaRandom = 10;

        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(lunghezzaRandom);
        for (int i = 0; i < lunghezzaRandom; i++) {
            int randomInt = sr.nextInt(perRandom.length());
            char randomChar = perRandom.charAt(randomInt);
            sb.append(randomChar);
        }
        
        tracking = sb.toString();
        return tracking;
		
	}
	
}
