package com.unical.unitransport.controller.persistence.shipment.state;

public class Stato {
	
	private StatePattern stato;
	
	public Stato(int x) {
		if(x==0) {
			stato = new LabelCreated();
		} else if (x==1) {
			stato = new Shipped();
		} else if(x==2) {
			stato = new OutForDelivery();
		} else if (x==3) {
			stato = new Delivery();
		} else if (x==4) {
			stato = new Completed();
		} else 
		stato = new LabelCreated();
	}
	
	public void statoPrecedente() {
		this.stato= stato.precedente();
	}
	
	public void statoSuccessivo() {
		this.stato= stato.successivo();

	}

	public int getStato() {
		return stato.getStato();
	}

}
