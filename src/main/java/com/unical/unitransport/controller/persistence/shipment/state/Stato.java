package com.unical.unitransport.controller.persistence.shipment.state;

public class Stato {
	
	private StatePattern stato;
	
	public Stato(int x) {
		if(x==0) {
			stato = new LabelCreated();
			this.stato.stato = 0;
		} else if (x==1) {
			stato = new Shipped();
			this.stato.stato = 1;
		} else if(x==2) {
			stato = new OutForDelivery();
			this.stato.stato = 2;
		} else if (x==3) {
			stato = new Delivery();
			this.stato.stato = 3;
		} else if (x==4) {
			stato = new Completed();
			this.stato.stato = 4;
		}
		stato = new Unknown();
	}
	
	public void statoPrecedente() {
		this.stato.precedente(this);
	}
	
	public void statoSuccessivo(Stato stato) {
		this.stato.successivo(this);

	}
	

	public int getStato() {
		return stato.getStato();
	}



}
