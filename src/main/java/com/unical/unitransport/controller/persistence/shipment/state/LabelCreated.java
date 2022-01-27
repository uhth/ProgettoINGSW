package com.unical.unitransport.controller.persistence.shipment.state;

public class LabelCreated extends StatePattern{

	@Override
	public int precedente(Stato stato) {
		this.setStato(-1);
		return this.getStato();
	}

	@Override
	public int successivo(Stato stato) {
		this.setStato(1);
		return this.getStato();
	}

}
