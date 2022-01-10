package com.unical.unitransport.controller.persistence.shipment;

public class ShipmentSenderReceiver {
	
	private int shipment_id;
	private String sender_email;
	private String receiver_email;
	
	
	public ShipmentSenderReceiver(int shipment_id, String sender_email, String receiver_email) {
		super();
		this.shipment_id = shipment_id;
		this.sender_email = sender_email;
		this.receiver_email = receiver_email;
	}


	public int getShipmentId() {
		return shipment_id;
	}


	public String getSenderEmail() {
		return sender_email;
	}


	public String getReceiverEmail() {
		return receiver_email;
	}


	public void setShipmentId(int shipment_id) {
		this.shipment_id = shipment_id;
	}


	public void setSenderEmail(String sender_email) {
		this.sender_email = sender_email;
	}


	public void setReceiver_emai(String receiver_emai) {
		this.receiver_email = receiver_emai;
	}
	
	
	
}
