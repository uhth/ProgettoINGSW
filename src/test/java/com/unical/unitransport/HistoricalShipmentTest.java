package com.unical.unitransport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unical.unitransport.controller.persistence.shipment.Shipment;
import com.unical.unitransport.controller.persistence.shipment.state.HistoricalShipment;
import com.unical.unitransport.controller.persistence.shipment.state.HistoricalShipmentDAO;

@SpringBootTest
public class HistoricalShipmentTest {
	static public Shipment spedizione;
	
	@BeforeAll
	public static void resetHistoricalShipment() {
	//	HistoricalShipmentDAO.removeAll();
		spedizione = new Shipment( "SpedizioneTest", "Via Rossini, Rende 200", "Via Rossini, Rende, 200", " Viale Giacomo Mancini, Cosenza, 100 " );
	}
	
	@Test
	@DisplayName("test historicalshipment")
	void historicalshipmentTest() {
		Date date = new Date();
		assertEquals(true, HistoricalShipmentDAO.insert(
				new HistoricalShipment(spedizione.getTrackingNumber(),new Timestamp(date.getTime()),0,"Roma (RM)")));
		
	}
}
