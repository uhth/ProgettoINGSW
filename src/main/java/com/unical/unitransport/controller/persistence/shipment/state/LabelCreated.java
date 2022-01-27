package com.unical.unitransport.controller.persistence.shipment.state;

public class LabelCreated implements StatePattern{

	@Override
	public StatePattern precedente() {
		return new Unknown();
	}

	@Override
	public StatePattern successivo() {
		return new Shipped();
	}

	@Override
	public int getStato() {
		return 0;
	}


}
