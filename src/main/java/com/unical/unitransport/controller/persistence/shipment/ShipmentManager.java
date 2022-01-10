package com.unical.unitransport.controller.persistence.shipment;

import java.util.UUID;

public interface ShipmentManager {
	
	public static Shipment registerShipment( String sender_email, String receiver_email ) {
		String tracking_number = UUID.randomUUID().toString();
		while( ShipmentsDAO.getByTrackingNumber( tracking_number ) != null )
			tracking_number = UUID.randomUUID().toString();
		
		Shipment shipment = new Shipment( tracking_number );
		ShipmentsDAO.insert( shipment );
		shipment = ShipmentsDAO.getByTrackingNumber( tracking_number );
		ShipmentSenderReceiver shipmentSenderReceiver = new ShipmentSenderReceiver( shipment.getShipmentId(), sender_email, receiver_email );
		ShipmentsSenderReceiverDAO.insert( shipmentSenderReceiver );
		return shipment;
	}
}
