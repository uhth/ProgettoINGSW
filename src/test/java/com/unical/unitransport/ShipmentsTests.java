package com.unical.unitransport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.unical.unitransport.controller.persistence.account.AccountsManager;
import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsDAO;
import com.unical.unitransport.controller.persistence.shipment.ShipmentsManager;

@SpringBootTest
class ShipmentsTests {
		
	@BeforeAll
	public static void addAccount() {
		AccountsManager.registerAccount( "a", "a1" );
		AccountsManager.registerAccount( "b", "b1" );
			
		ShipmentsDAO.removeAll(); //ShipmentsSenderReceiver should be updated to due to its constraints
		
		ShipmentsDAO.insert( new Shipment( "sadasfa", "Via Rossini, Rende 200", "Via Rossini, Rende, 200", " Viale Giacomo Mancini, Cosenza, 100 " ) );
	}
		
		
	@Test
	@DisplayName( "ShipmentManager Test" )
	void shipmentManagerTest() {
		
		//add shipment
		assertEquals( Shipment.class, ShipmentsManager.registerShipment( "a", "b" ).getClass() );
		assertEquals( Shipment.class, ShipmentsManager.registerShipment( "a", "b" ).getClass() );
		
		//update shipment
		String location = "newLocation";
		int status = Shipment.OUT_FOR_DELIVERY;
	/*	String trackigNumber = ShipmentsDAO.getAll().get( 0 ).getTrackingNumber();
		assertEquals( true, ShipmentsManager.updateShipment( trackigNumber, status, location ) );
		assertEquals( location, ShipmentsDAO.getByTrackingNumber( trackigNumber ).getLastLocation() );
		assertEquals( status, ShipmentsDAO.getByTrackingNumber( trackigNumber ).getStatus() );
	*/}

}
