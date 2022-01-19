package com.unical.unitransport.controller.persistence.shipment;

import java.sql.Timestamp;

public class Shipment {
	
	public static final int UNKNOWN = -1;
	public static final int LABEL_CREATED = 0;
	public static final int SHIPPED = 1;
	public static final int OUT_FOR_DELIVERY = 2;
	public static final int DELIVERY = 3;
	public static final int COMPLETED = 4;
	public static final int CANCELED = 5;
	
	private int shipment_id;
	private String tracking_number;
	private int status;
	private Timestamp created_on;
	private Timestamp last_update;
	private String last_location;
	private String sender_location;
	private String receiver_location;
	
	public Shipment( String tracking_number ) {
		this.tracking_number = tracking_number;
		this.status = LABEL_CREATED;
	}
	
	public Shipment( String tracking_number, String last_location, String sender_location, String receiver_location ) {
		this.tracking_number = tracking_number;
		this.status = LABEL_CREATED;
		this.last_location = last_location;
		this.sender_location = sender_location;
		this.receiver_location = receiver_location;
	}
	
	//intended for dao's use only
	public Shipment(int shipment_id, String tracking_number, int status, Timestamp created_on, Timestamp last_update, String last_location, String sender_location, String receiver_location ) {
		this.shipment_id = shipment_id;
		this.tracking_number = tracking_number;
		this.status = status;
		this.created_on = created_on;
		this.last_update = last_update;
		this.last_location = last_location;
		this.sender_location = sender_location;
		this.receiver_location = receiver_location;
	}

	public int getShipmentId() {
		return shipment_id;
	}
	
	public String getTrackingNumber() {
		return tracking_number;
	}
	
	public void setShipmentId( int shipment_id ) {
		this.shipment_id = shipment_id;
	}
	
	public void setTrackingNumber( String tracking_number ) {
		this.tracking_number = tracking_number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Timestamp getLastUpdate() {
		return last_update;
	}
	
	public void setLastUpdate( Timestamp last_update ) {
		this.last_update = last_update;
	}
	
	public Timestamp getCreatedOn() {
		return created_on;
	}
	
	public void setCreatedOn( Timestamp created_on ) {
		this.created_on = created_on;
	}
	
	public String getLastLocation() {
		return last_location;
	}
	
	public void setLastLocation( String last_location ) {
		this.last_location = last_location;
	}
	
	
	public String getSenderLocation() {
		return sender_location;
	}

	public void setSenderLocation(String sender_location) {
		this.sender_location = sender_location;
	}

	public String getReceiverLocation() {
		return receiver_location;
	}

	public void setReceiverLocation(String receiver_location) {
		this.receiver_location = receiver_location;
	}

	public String stato() {
		String state = "";
		if(status==Shipment.UNKNOWN)
			state+= "Nessuna informazione attualmente disponibile";
		else if (status==Shipment.LABEL_CREATED)
			state+="LA SPEDIZIONE E' STATA CREATA";
		else if (status==Shipment.OUT_FOR_DELIVERY)
			state+="LA SPEDIZIONE E' PRONTA PER LA CONSEGNA";		
		else if (status==Shipment.SHIPPED)
			state+="LA SPEDIZIONE E' PARTITA";		
		else if (status==Shipment.DELIVERY)
			state+="LA SPEDIZIONE E' IN CONSEGNA";
		else if (status==Shipment.COMPLETED)
			state+="LA SPEDIZIONE E' STATA COMPLETATA";		
		else if (status==Shipment.CANCELED)
			state+="LA SPEDIZIONE E' STATA ANNULLATA";		

		
		return state;
	}
	
	public String localita() {
		
		if (status>=Shipment.SHIPPED && status<=Shipment.COMPLETED)
			return "PRESSO: " + this.last_location;
		
		return "LOCALIZZAZIONE NON DISPONIBILE";
			
	}
	

	
}
