package com.unical.unitransport.controller.persistence.shipment.state;

public class Shipped implements StatePattern{


	@Override
	public StatePattern precedente() {
		return new LabelCreated();
	}

	@Override
	public StatePattern successivo() {
		return new OutForDelivery();
	}

	@Override
	public int getStato() {
		return 1;
	}

}
