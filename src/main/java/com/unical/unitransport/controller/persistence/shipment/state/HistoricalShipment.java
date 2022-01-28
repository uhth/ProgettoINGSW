package com.unical.unitransport.controller.persistence.shipment.state;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.unical.unitransport.controller.persistence.shipment.Shipment;

public class HistoricalShipment {

	private String tracking_number;
	private Timestamp date;
	private int status;
	private String last_location;
	
	
	public HistoricalShipment(String tracking_number, Timestamp date, int status, String last_location) {
		super();
		this.tracking_number = tracking_number;
		this.date = date;
		this.status = status;
		this.last_location = last_location;
	}
	public HistoricalShipment(Shipment ship) {
		this.tracking_number = ship.getTrackingNumber();
		this.date = ship.getLastUpdate();
		this.status = ship.getStatus();
		this.last_location = ship.getLastLocation();
	}
	
	public HistoricalShipment() {
	}

	public String getTracking_number() {
		return tracking_number;
	}


	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getLast_location() {
		return last_location;
	}


	public void setLast_location(String last_location) {
		this.last_location = last_location;
	}

	public String getStato() {
		String state = "";
		if(status==Shipment.UNKNOWN)
			state = "Nessuna informazione attualmente disponibile";
		else if (status==Shipment.LABEL_CREATED)
			state ="LA SPEDIZIONE E' STATA CREATA";
		else if (status==Shipment.OUT_FOR_DELIVERY)
			state ="LA SPEDIZIONE E' PRONTA PER LA CONSEGNA";		
		else if (status==Shipment.SHIPPED)
			state ="LA SPEDIZIONE E' PARTITA";		
		else if (status==Shipment.DELIVERY)
			state ="LA SPEDIZIONE E' IN CONSEGNA";
		else if (status==Shipment.COMPLETED)
			state ="LA SPEDIZIONE E' STATA COMPLETATA";		
		else if (status==Shipment.CANCELED)
			state ="LA SPEDIZIONE E' STATA ANNULLATA";		
		
		return state;
	}
	
	public String getDataFormatted() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}
}
