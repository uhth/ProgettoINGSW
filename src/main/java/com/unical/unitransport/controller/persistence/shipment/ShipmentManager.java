package com.unical.unitransport.controller.persistence.shipment;

import java.util.UUID;

public interface ShipmentManager {
	
	public static Shipment registerShipment( String sender_email, String receiver_email ) {
		String tracking_number = UUID.randomUUID().toString();
		while( ShipmentsDAO.getByTrackingNumber( tracking_number ) != null )
			tracking_number = UUID.randomUUID().toString();
		
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
	
	public static boolean unregisterShipment( String trackingNumber ) {
		Shipment shipment = ShipmentsDAO.getByTrackingNumber( trackingNumber );
		return ShipmentsDAO.remove( shipment );
	}
	
}
