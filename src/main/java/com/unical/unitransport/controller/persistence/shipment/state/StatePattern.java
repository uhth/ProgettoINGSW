package com.unical.unitransport.controller.persistence.shipment.state;

public abstract class StatePattern{
	
	public int stato;
	public abstract int precedente(Stato stato);
	public abstract int successivo(Stato stato);
	
	public void setStato(int x) {
		this.stato=x;
	}

	public int getStato() {
		return stato;
	}

}
