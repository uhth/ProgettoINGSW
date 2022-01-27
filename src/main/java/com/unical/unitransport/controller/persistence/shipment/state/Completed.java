package com.unical.unitransport.controller.persistence.shipment.state;

public class Completed implements StatePattern{

	@Override
	public StatePattern precedente() {
		return new Delivery();
	}

	@Override
	public StatePattern successivo() {
		return new Unknown();
	}

	@Override
	public int getStato() {
		return 4;
	}


}
