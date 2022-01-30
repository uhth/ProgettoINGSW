package com.unical.unitransport.controller.persistence.shipment.state;

public class Unknown implements StatePattern{

	@Override
	public StatePattern precedente() {
		return new Unknown();
	}

	@Override
	public StatePattern successivo() {
		return new LabelCreated();
	}

	@Override
	public int getStato() {
		return -1;
	}


}
