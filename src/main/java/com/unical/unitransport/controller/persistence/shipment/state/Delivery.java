package com.unical.unitransport.controller.persistence.shipment.state;

public class Delivery implements StatePattern{

	@Override
	public StatePattern precedente() {
		return new OutForDelivery();
	}

	@Override
	public StatePattern successivo() {
		return new Completed();
	}

	@Override
	public int getStato() {
		return 3;
	}



}
