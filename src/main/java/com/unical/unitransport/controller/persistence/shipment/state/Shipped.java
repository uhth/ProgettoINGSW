package com.unical.unitransport.controller.persistence.shipment.state;

public class Shipped extends StatePattern{

	@Override
	public int precedente(Stato stato) {
		this.setStato(0);
		
		return this.getStato();
	}

	@Override
	public int successivo(Stato stato) {
		this.setStato(2);
		return this.getStato();
	}

}
