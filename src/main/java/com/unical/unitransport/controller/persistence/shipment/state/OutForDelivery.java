package com.unical.unitransport.controller.persistence.shipment.state;

public class OutForDelivery implements StatePattern{

	@Override
	public StatePattern precedente() {
		return new Shipped();
	}

	@Override
	public StatePattern successivo() {
		return new Delivery();
	}

	@Override
	public int getStato() {
		return 2;
	}

}
