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
	
	public Shipment( String tracking_number ) {
		this.tracking_number = tracking_number;
		this.status = LABEL_CREATED;
	}
	
	public Shipment(int shipment_id, String tracking_number, int status, Timestamp created_on, Timestamp last_update) {
		this.shipment_id = shipment_id;
		this.tracking_number = tracking_number;
		this.status = status;
		this.created_on = created_on;
		this.last_update = last_update;
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
	
	
}
